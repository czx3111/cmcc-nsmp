package com.ultrapower.web;

import com.ultrapower.dao.AmUserMapper;
import com.ultrapower.pojo.AmAsset;
import com.ultrapower.pojo.AmUser;
import com.ultrapower.utils.PkUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Jobs {

    @Autowired
    AmUserMapper userMapper;
    public void job1(){
        AmUser amUser = new AmUser();
        amUser.setPkNsmpUser(PkUtils.getPrimaryKey());
        amUser.setUserAccount("czx");
        amUser.setUserPassword("123123");
        Short s=0;
        amUser.setComeFrom(s);
        userMapper.insert(amUser);
        System.out.println("job1:"+new Date(System.currentTimeMillis()));
    }

    //任务2
    public void job2() {
        System.out.println("job2:"+new Date(System.currentTimeMillis()));
    }

}
