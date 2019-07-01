package com.ultrapower.web;

import com.ultrapower.dao.AmBsGroupMapper;
import com.ultrapower.pojo.BsGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestController {

    @Autowired
    AmBsGroupMapper bsGroupMapper;

    @GetMapping("/test")
    public List<BsGroupVO>  test(){
        List<BsGroupVO> bsGroupVOS = bsGroupMapper.initBsGroupTree();
        return bsGroupVOS;
    }

    @GetMapping("/test11")
    public Map<String,Object> test1() {
        List<String> x=Arrays.asList("星期一","星期二","星期三","星期四","星期五","星期六","星期天");
        List<String> y=Arrays.asList("101","155","66","530","421","212","336");
        Map<String,Object> map=new HashMap<>();
        map.put("x",x);
        map.put("y",y);
        return map;
    }
}
