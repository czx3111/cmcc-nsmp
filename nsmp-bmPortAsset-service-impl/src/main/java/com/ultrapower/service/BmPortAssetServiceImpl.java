package com.ultrapower.service;

import com.ultrapower.dao.AdcBmPortAssetMapper;
import com.ultrapower.pojo.AdcBmPortAsset;
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

    public Map<String, Object> carregarSelect() {
        List<AdcBmPortAsset> adcBmPortAssets = adcBmPortAssetMapper.selectByExample(null);
        Map<String,Object> map=new HashMap<String, Object>();
        List<String> list=new ArrayList<String>();
        for (int i=0;i<adcBmPortAssets.size();i++){
            AdcBmPortAsset adcBmPortAsset = adcBmPortAssets.get(i);
            String provCode = adcBmPortAsset.getProvCode();
            list.add(provCode);
        }

        return null;
    }
}
