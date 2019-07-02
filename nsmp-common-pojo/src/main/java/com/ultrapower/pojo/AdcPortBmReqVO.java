package com.ultrapower.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 用来封装在添加资产端口基础页面的请求数据
 */
public class AdcPortBmReqVO implements Serializable {

    /**
     * 多行端口基础
     */
    List<AdcBmPort> adcBmPort;

    /**
     * 对应的已选资产列表的id
     */
    String pkAssets;

    public List<AdcBmPort> getAdcBmPort() {
        return adcBmPort;
    }

    public void setAdcBmPort(List<AdcBmPort> adcBmPort) {
        this.adcBmPort = adcBmPort;
    }

    public String getPkAssets() {
        return pkAssets;
    }

    public void setPkAssets(String pkAssets) {
        this.pkAssets = pkAssets;
    }
}
