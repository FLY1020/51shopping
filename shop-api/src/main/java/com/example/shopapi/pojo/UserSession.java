package com.example.shopapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class UserSession implements Serializable {
    private String session_user;
}
