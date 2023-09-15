package com.ychentest.controller;

import com.ychentest.domain.Userinfo;
import com.ychentest.service.Userinfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 注册页面
 * */

@RestController
@RequestMapping("/users/sign")
public class sign {

    @Autowired
    private Userinfoservice userinfoservice;

    @PostMapping
    public Result save(@RequestBody Userinfo userinfo){
        boolean flag = userinfoservice.save(userinfo);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }


}
