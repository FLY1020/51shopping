package com.example.cart.bean;

import lombok.Data;
import org.apache.ibatis.annotations.Insert;

import java.io.Serializable;

@Data
public class Cart implements Serializable {
    private Insert carid;
    private String username;
    private int productid;
}
