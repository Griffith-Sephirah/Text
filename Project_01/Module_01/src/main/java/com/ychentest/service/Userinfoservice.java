package com.ychentest.service;

import com.ychentest.domain.Userinfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Userinfoservice {
    /**
     * 注册，储存用户信息
     * @param userinfo
     * @return
     */
    public boolean save(Userinfo userinfo);

    /**
     * 用户发送的信息
     * @param text
     * @return
     */
    public boolean analysis(String text);

    /**
     * 按用户名查询（登入时用到）
     * @param username
     * @return
     */
    public Userinfo getByusername(String username);

}
