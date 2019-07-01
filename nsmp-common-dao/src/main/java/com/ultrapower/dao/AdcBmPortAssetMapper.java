package com.ultrapower.dao;

import com.ultrapower.pojo.AdcBmPortAsset;
import com.ultrapower.pojo.AdcBmPortAssetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdcBmPortAssetMapper {
    int countByExample(AdcBmPortAssetExample example);

    int deleteByExample(AdcBmPortAssetExample example);

    int deleteByPrimaryKey(String pkBmPortAsset);

    int insert(AdcBmPortAsset record);

    int insertSelective(AdcBmPortAsset record);

    List<AdcBmPortAsset> selectByExample(AdcBmPortAssetExample example);

    AdcBmPortAsset selectByPrimaryKey(String pkBmPortAsset);

    int updateByExampleSelective(@Param("record") AdcBmPortAsset record, @Param("example") AdcBmPortAssetExample example);

    int updateByExample(@Param("record") AdcBmPortAsset record, @Param("example") AdcBmPortAssetExample example);

    int updateByPrimaryKeySelective(AdcBmPortAsset record);

    int updateByPrimaryKey(AdcBmPortAsset record);
}