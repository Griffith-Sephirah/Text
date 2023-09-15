package com.ychentest.dao;

import com.ychentest.domain.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface Userinfodao {

    //注册，储存用户信息
    @Insert("INSERT INTO userinfo (username,password) values (#{username},#{password})")
    public int save(Userinfo userinfo);

    @Select("select * from userinfo where id = #{id}")
    public Userinfo getById(Integer id);

    @Select("select * from userinfo where username = #{username}")
    public Userinfo getByusername(String username);
}
