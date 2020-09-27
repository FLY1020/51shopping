package com.example.order.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class order implements Serializable {
    private int orderid;
    private String username;
    private int productid;
    private int delivered;//是否发货 1为已发货
}
