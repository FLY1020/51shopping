package com.example.login.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class UserSession implements Serializable {
    private String session_user;
}
