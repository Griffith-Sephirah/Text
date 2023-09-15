package com.ychentest.controller;

import com.ychentest.domain.Userinfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登出
 * */

@RestController
@RequestMapping("/users/logout")
public class logout {

    @PostMapping
    public Userinfo logout(String s, HttpServletRequest request){
        System.out.println("注销...");
        // 清空用户信息
        request.getSession().removeAttribute("loginUser");
        return (Userinfo) request.getSession().getAttribute("userInfo");
    }
}
