package com.ychentest.controller;


import com.ychentest.domain.Userinfo;
import com.ychentest.service.Userinfoservice;
import com.ychentest.service.impl.Userinfoserviceimpl;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 登录
 * */

@RestController
@RequestMapping("/users/log")
public class log {
    @Autowired
    private Userinfoservice userinfoservice;

    @PostMapping
    public String login(String username, String password, HttpSession session) {
        Userinfo userinfo = userinfoservice.getByusername(username);
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(userinfo.toString());
//        System.out.println(userinfo.getPassword());
        if(userinfo!=null && password.equals(userinfo.getPassword())){
            session.setAttribute("loginUser",username);
            System.out.println("登录成功");
            return username+" Login succeeded";
        }
        return "Incorrect username or password";
    }

}
