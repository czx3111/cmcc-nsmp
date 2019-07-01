package com.ultrapower.dao;

import com.ultrapower.pojo.AdcBmPort;
import com.ultrapower.pojo.AdcBmPortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdcBmPortMapper {
    int countByExample(AdcBmPortExample example);

    int deleteByExample(AdcBmPortExample example);

    int deleteByPrimaryKey(String pkBmPort);

    int insert(AdcBmPort record);

    int insertSelective(AdcBmPort record);

    List<AdcBmPort> selectByExample(AdcBmPortExample example);

    AdcBmPort selectByPrimaryKey(String pkBmPort);

    int updateByExampleSelective(@Param("record") AdcBmPort record, @Param("example") AdcBmPortExample example);

    int updateByExample(@Param("record") AdcBmPort record, @Param("example") AdcBmPortExample example);

    int updateByPrimaryKeySelective(AdcBmPort record);

    int updateByPrimaryKey(AdcBmPort record);
}