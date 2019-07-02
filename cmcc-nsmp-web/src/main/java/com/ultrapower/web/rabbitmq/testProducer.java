package com.ultrapower.web.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext-rabbitmq.xml")
public class testProducer {
    @Autowired
    MessageProducer messageProducer;
    @Test
    public void Test1(){
        Map<String,Object> map=new HashMap<>();
        map.put("id",1001);
        map.put("code",1);
        map.put("tel","13111111111");
        messageProducer.sendMessage(map);
    }
}
