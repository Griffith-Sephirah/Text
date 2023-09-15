package com.ychentest;

import com.ychentest.dao.Userinfodao;
import com.ychentest.domain.Userinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Userinfodao userinfodao;

    @Test
    void contextLoads() {
        Userinfo userinfo = userinfodao.getById(1);
        System.out.println(userinfo);
    }

}
