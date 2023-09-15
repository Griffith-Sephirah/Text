package com.ychentest.controller;

import com.ychentest.domain.Userinfo;
import com.ychentest.service.Userinfoservice;
import com.ychentest.service.impl.Userinfoserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.awt.SystemColor.text;

/**
 * 主页面
 * */

@RestController
@RequestMapping("/users")
public class userinfocontroller {

    @Autowired
    private Userinfoservice userinfoservice;

    @PostMapping
    public String analysis(String text){
        boolean flag = userinfoservice.analysis(text);
        //return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
        String answer = "PS:由于实在是连不上ChatGPT了，就谁便模拟一下返回值。";
        System.out.println(answer+text);
        return answer+text;
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("id ==> "+id);
        return "hello , spring boot!";
    }
}
