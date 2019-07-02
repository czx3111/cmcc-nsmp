package com.ultrapower.service;

import com.ultrapower.dao.AdcBmPortAssetMapper;
import com.ultrapower.dao.AdcBmPortMapper;
import com.ultrapower.dao.AmAssetMapper;
import com.ultrapower.dao.AmAssetTypeMapper;
import com.ultrapower.pojo.*;
import com.ultrapower.utils.PkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmPortAssetServiceImpl implements BmPortAssetService {
    @Autowired
    AdcBmPortAssetMapper adcBmPortAssetMapper;
    @Autowired
    AmAssetMapper amAssetMapper;
    @Autowired
    AdcBmPortMapper adcBmPortMapper;

    public Map<String, Object> carregarSelect() {
        List<AmAsset> amAssets = amAssetMapper.selectByExample(null);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("amAssets",amAssets);
        return map;
    }

    public Map<String, Object> addAdcBmPort(AdcPortBmReqVO adcPortBmReqVO) {

        Map<String,Object> map=new HashMap<String, Object>();

        List<String> portIds=new ArrayList<String>();

        //1.添加端口基准
        List<AdcBmPort> list = adcPortBmReqVO.getAdcBmPort();
        for (int i=0;i<list.size();i++){
            AdcBmPort port = list.get(i);
            String primaryKey = PkUtils.getPrimaryKey();
            port.setPkBmPort(primaryKey);
            int insert = adcBmPortMapper.insert(port);
            if (insert>0){
                portIds.add(primaryKey);
            }
        }

        //2.端口资产关联表建立对应关系

        String[] assetIds  = adcPortBmReqVO.getPkAssets().split(",");
        for (String assetId:assetIds ){
            for (String portId: portIds){
                AdcBmPortAsset adcBmPortAsset = new AdcBmPortAsset();
                adcBmPortAsset.setPkAsset(assetId);
                adcBmPortAsset.setPkBmPort(portId);
                adcBmPortAsset.setPkBmPortAsset(PkUtils.getPrimaryKey());
                int insert = adcBmPortAssetMapper.insert(adcBmPortAsset);
            }
        }
        map.put("code",1);
        return map;
    }

}
