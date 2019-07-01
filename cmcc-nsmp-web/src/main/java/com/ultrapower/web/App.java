package com.ultrapower.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext-mongodb.xml")
public class App {
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void Test1(){
        Student student = new Student();
        student.setName("zhansan");
        student.setAge("18");
        mongoTemplate.insert(student);
    }



}
