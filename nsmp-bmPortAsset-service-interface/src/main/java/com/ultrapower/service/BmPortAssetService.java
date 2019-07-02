package com.ultrapower.service;

import com.ultrapower.pojo.AdcPortBmReqVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface BmPortAssetService {

     Map<String,Object> carregarSelect();

     Map<String,Object> addAdcBmPort(AdcPortBmReqVO adcPortBmReqVO);
}
