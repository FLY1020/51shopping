package com.example.login.service;

import com.example.login.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    //查找一个用户
    public User getByUser(String username, String password);

    //添加一个用户
    public int setByUser(User user);

    //根据用户查找一个用户
    public User getByNameOne(String username);

    //根据号码查找一个用户是否注册
    public User getByPhoneOne(String phone);


}
