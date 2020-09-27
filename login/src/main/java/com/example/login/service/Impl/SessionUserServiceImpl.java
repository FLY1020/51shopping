package com.example.login.service.Impl;

import com.example.login.bean.UserSession;
import com.example.shopapi.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class SessionUserServiceImpl implements SessionUserService {

    @Autowired
    UserSession userSession;

    @Override
    public String getSession() {
        return userSession.getSession_user();
    }
}
