package com.example.login.service.Impl;

import com.example.login.bean.User;
import com.example.login.mapper.LoginMapper;
import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User getByUser(String username, String password) {
        return loginMapper.getByUser(username, password);
    }

    @Override
    public int setByUser(User user) {
        return loginMapper.setByUser(user);
    }

    @Override
    public User getByNameOne(String username) {
        return loginMapper.getByNameOne(username);
    }

    @Override
    public User getByPhoneOne(String phone) {
        return loginMapper.getByPhoneOne(phone);
    }


}
