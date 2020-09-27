package com.example.login.mapper;

import com.example.login.bean.User;
import org.apache.ibatis.annotations.*;


//指定这是一个操作数据库的mapper
//@Mapper
public interface LoginMapper {

    //查询一个用户
    @Select("select * from user where username=#{username} and password=#{password}")
    public User getByUser(String username, String password);

    //注册一个用户
    @Insert("insert into  user (email,password,phone,username) values(#{email},#{password},#{phone},#{username})")
    public int setByUser(User user);


    //根据用户查找一个用户
    @Select("select * from user where username=#{username}")
    public User getByNameOne(String username);

    //根据号码查找一个用户是否注册
    @Select("select * from user where phone=#{phone}")
    public User getByPhoneOne(String phone);
}
