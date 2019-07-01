package com.ultrapower.service;

import com.ultrapower.dao.*;
import com.ultrapower.pojo.*;
import com.ultrapower.utils.PkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BsGroupProvServiceImpl implements BsGroupProvService {

    @Autowired
    AmBsGroupMapper bsGroupMapper;

    @Autowired
    AmBsGroupProvMapper bsGroupProvMapper;

    @Autowired
    AmBsProvMapper bsProvMapper;

    @Autowired
    BdmProvMapper bdmProvMapper;

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AmAssetTypeMapper amAssetTypeMapper;

    public List<BsGroupVO> initBsGroupTree() {
        List<BsGroupVO> bsGroupVOS = bsGroupMapper.initBsGroupTree();
        return bsGroupVOS;
    }

    public Map<String, Object> findTableDataByNodeId(String nodeId) {
        Map<String,Object> map = new HashMap<String, Object>();

        //1.当前节点基本信息(节点树的右侧)
        AmBsGroup amBsGroup = bsGroupMapper.selectByPrimaryKey(nodeId);
        map.put("amBsGroup",amBsGroup);

        //2.省份业务系统相关表格数据
        List<ProvDTO> provDTOS = selectProvByGroupId(nodeId);
        map.put("provDTOS",provDTOS);

        return map;
    }

    public List<ProvDTO> selectProvByGroupId(String groupId) {
        List<ProvDTO> provDTOS = bsGroupProvMapper.selectProvByGroupId(groupId);
        return provDTOS;
    }

    public int deleteProvGroupMapping(String groupBsId, String provBsId) {

        AmBsGroupProvExample example = new AmBsGroupProvExample();
        AmBsGroupProvExample.Criteria criteria = example.createCriteria();
        criteria.andPkBsGroupEqualTo(groupBsId);
        criteria.andPkBsProvEqualTo(provBsId);
        //  delete from xxx where pkbsgroup = xx pkbsprov = xx;
        int i = bsGroupProvMapper.deleteByExample(example);
        return i;
    }

    public List<BdmProv> selectProvDate() {

        List<BdmProv> bdmProvs = bdmProvMapper.selectByExample(null);

        return bdmProvs;
    }


    public List<AmBsProv> findBsProvByProvCode(String provCode,String groupId) {

        AmBsProvExample example = new AmBsProvExample();
        AmBsProvExample.Criteria criteria = example.createCriteria();

        //条件1、省份code
        criteria.andProvCodeEqualTo(provCode);

        //条件2、数据是未删除状态
        Short s = 1 ;//1.已删除
        criteria.andIsDeletedNotEqualTo(s);

        //条件3、数据是未绑定状态
        //根据当前选中的集团节点，查看，已经绑定了那些省份--》id
        List<String> provIds = findBoundProvIds(groupId);
        if(provIds != null && provIds.size()>0){
            criteria.andPkBsProvNotIn(provIds);
        }

        List<AmBsProv> amBsProvs = bsProvMapper.selectByExample(example);

        return amBsProvs;
    }

    public Map<String, Object> saveGroupProvMapping(String groupId, String bsProvIds,String token) {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            String[] split = bsProvIds.split(",");
            for (String bsProvId : split){
                AmBsGroupProv bsGroupProv = new AmBsGroupProv();

                bsGroupProv.setPkBsGroupProv(PkUtils.getPrimaryKey());
                bsGroupProv.setPkBsGroup(groupId);
                bsGroupProv.setPkBsProv(bsProvId);
                Short s = 1;
                bsGroupProv.setMatchType(s);
                bsGroupProv.setPkCreator(PkUtils.getUserIdByToken(token,redisTemplate));
                bsGroupProv.setCreateTime(new Date());

                bsGroupProvMapper.insert(bsGroupProv);
            }
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据指定集团id查询已经绑定了哪些省份系统id
     * @param groupId
     */
    public List<String> findBoundProvIds(String groupId){
        AmBsGroupProvExample example = new AmBsGroupProvExample();
        AmBsGroupProvExample.Criteria criteria = example.createCriteria();
        criteria.andPkBsGroupEqualTo(groupId);

        List<AmBsGroupProv> amBsGroupProvs = bsGroupProvMapper.selectByExample(example);

        List<String> provIds = new ArrayList<String>();

        for (AmBsGroupProv bsGroupProv : amBsGroupProvs){
            provIds.add(bsGroupProv.getPkBsProv());
        }
        return provIds;
    }


    public Map<String, Object> bsGroupProvMappingByProvRegex(String provRegex) {
        AmBsProvExample example = new AmBsProvExample();
        AmBsProvExample.Criteria criteria = example.createCriteria();
        List<AmBsGroupProv> amBsGroupProvs = bsGroupProvMapper.selectByExample(null);
        List<String> provIds  = bsGroupListToStringList(amBsGroupProvs);
        criteria.andProvCodeLike("%"+provRegex+"%");
        if(provIds!=null && provIds.size()>0){
            criteria.andPkBsProvNotIn(provIds);
        }
        List<AmBsProv> list = bsProvMapper.selectByExample(example);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",list);
        return map;
    }



    List<String> bsGroupListToStringList(List<AmBsGroupProv> amBsGroupProvs){
        List<String> list = new ArrayList<String>();
        for(AmBsGroupProv bsGroupProv : amBsGroupProvs){
            list.add(bsGroupProv.getPkBsProv());
        }
        return list;
    }

    public Map<String, Object> bsGroupAdd(AddGroupDTO groupDTO, String token) {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            AmBsGroup amBsGroup = new AmBsGroup();
            amBsGroup.setBsName(groupDTO.getBsName());
            amBsGroup.setBsCode(groupDTO.getBsCode());
            amBsGroup.setDisplaySeq(groupDTO.getDisplaySeq());
            amBsGroup.setBsDesc(groupDTO.getBsDesc());
            amBsGroup.setMappingRegex(groupDTO.getMappingRegex());
            amBsGroup.setPkBsParent(groupDTO.getPkBsParent());

            String primaryKey = PkUtils.getPrimaryKey();
            amBsGroup.setPkBsGroup(primaryKey);
            Short s = 1; //手动录入
            amBsGroup.setBsSrc(s);
            Short d = 0;//未删除
            amBsGroup.setIsDeleted(d);
            amBsGroup.setPkCreator(PkUtils.getUserIdByToken(token,redisTemplate));
            amBsGroup.setCreateTime(new Date());
            amBsGroup.setPkMender(PkUtils.getUserIdByToken(token,redisTemplate));
            amBsGroup.setMendTimeLast(new Date());
            int insert = bsGroupMapper.insert(amBsGroup);
            if (insert>0){
                saveMapping(groupDTO,primaryKey,token);
            }
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Object> deleteBsGroupById(String pkBsGroup) {
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            int i = bsGroupMapper.deleteByPrimaryKey(pkBsGroup);
            AmBsGroupProvExample example = new AmBsGroupProvExample();
            AmBsGroupProvExample.Criteria criteria = example.createCriteria();
            criteria.andPkBsGroupEqualTo(pkBsGroup);
            int i1 = bsGroupProvMapper.deleteByExample(example);
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Object> initMgAssetQuery(GroupMgAssetQueryVO queryVO) {
        List<BdmProv> provs = bdmProvMapper.selectByExample(null);
        List<AmAssetType> assetTypes = amAssetTypeMapper.selectByExample(null);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("provs",provs);
        map.put("assetTypes",assetTypes);
        List<BsGroupMgAsset> bsGroupMgAssets = selectBsGroupMgAsset(queryVO);
        map.put("bsGroupMgAssets",bsGroupMgAssets);//查询表格数据
        return map;
    }



    public Map<String, Object> selectCurrentGroupMgAsset(Integer pageNum, Integer pageSize, String groupId) {
        String bsGroupName="";
        AmBsGroup amBsGroup = bsGroupMapper.selectByPrimaryKey(groupId);
        String bsName = amBsGroup.getBsName();
        if (amBsGroup.getPkBsParent()==null){
            bsGroupName=bsName;
        }else{
            AmBsGroup amBsGroup1 = bsGroupMapper.selectByPrimaryKey(amBsGroup.getPkBsParent());
            String bsName1 = amBsGroup1.getBsName();
            if (amBsGroup1.getPkBsParent()==null){
                bsGroupName=bsName1+"->"+bsName1;
            }else{
                AmBsGroup amBsGroup2 = bsGroupMapper.selectByPrimaryKey(amBsGroup1.getPkBsParent());
                String bsName2 = amBsGroup2.getBsName();
                bsGroupName=bsName2+"->"+bsName1+"->"+bsName1;
            }
        }
        return null;
    }

    public List<BsGroupMgAsset> selectBsGroupMgAsset(GroupMgAssetQueryVO queryVO) {
        List<BsGroupMgAsset> bsGroupMgAssets = bsGroupProvMapper.selectBsGroupMgAsset(queryVO);
        return bsGroupMgAssets;
    }

    public Map<String, Object> saveGroupProvRemapping(String token,AddGroupDTO groupDTO) {
        Map<String,Object> map =new HashMap<String, Object>();
        try {
            AmBsGroupProvExample example = new AmBsGroupProvExample();
            AmBsGroupProvExample.Criteria criteria = example.createCriteria();
            criteria.andPkBsGroupEqualTo(groupDTO.getPkBsGroup());
            int i = bsGroupProvMapper.deleteByExample(example);

            AmBsGroup amBsGroup = bsGroupMapper.selectByPrimaryKey(groupDTO.getPkBsGroup());
            amBsGroup.setMappingRegex(groupDTO.getMappingRegex());
            int k = bsGroupMapper.updateByPrimaryKey(amBsGroup);
            saveMapping(groupDTO,groupDTO.getPkBsGroup(),token);
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    public void saveMapping(AddGroupDTO groupDTO,String pkBsGroup,String token){
        String[] provIds = groupDTO.getBsProvIds().split(",");
        for (String pkBsProv : provIds){
            AmBsGroupProv bsGroupProv = new AmBsGroupProv();

            bsGroupProv.setPkBsGroupProv(PkUtils.getPrimaryKey());
            bsGroupProv.setPkBsGroup(pkBsGroup);
            bsGroupProv.setPkBsProv(pkBsProv);
            //0-自动映射
            Short m = 0;
            bsGroupProv.setMatchType(m);
            bsGroupProv.setPkCreator(PkUtils.getUserIdByToken(token,redisTemplate));
            bsGroupProv.setCreateTime(new Date());
            int insert1 = bsGroupProvMapper.insert(bsGroupProv);
        }
    }
}
