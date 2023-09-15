package com.ychentest.service.impl;

import com.ychentest.dao.Userinfodao;
import com.ychentest.domain.Userinfo;
import com.ychentest.service.Userinfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userinfoserviceimpl implements Userinfoservice {

    @Autowired
    private Userinfodao userinfodao;

    @Override
    public boolean save(Userinfo userinfo) {
        return userinfodao.save(userinfo) > 0;
    }

    @Override
    public boolean analysis(String text) {
        return true;
    }

    @Override
    public Userinfo getByusername(String username) {
        return userinfodao.getByusername(username);
    }


}
