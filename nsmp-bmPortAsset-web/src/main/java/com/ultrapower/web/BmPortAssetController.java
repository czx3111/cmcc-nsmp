package com.ultrapower.web;

import com.ultrapower.pojo.AdcPortBmReqVO;
import com.ultrapower.service.BmPortAssetService;
import org.omg.CORBA.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BmPortAssetController {
    @Autowired
    BmPortAssetService bmPortAssetService;

    @GetMapping("/carregarSelect")
    public Map<String,Object> carregarSelect(){
        Map<String, Object> map = bmPortAssetService.carregarSelect();
        return map;
    }

    @PostMapping("/addAdcBmPort")
    public Map<String,Object> addAdcBmPort(@RequestBody AdcPortBmReqVO adcPortBmReqVO){
        Map<String, Object> map = bmPortAssetService.addAdcBmPort(adcPortBmReqVO);
        return map;
    }

}
