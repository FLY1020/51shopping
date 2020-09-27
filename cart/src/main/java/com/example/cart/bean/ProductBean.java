package com.example.cart.bean;


import lombok.Data;

import java.io.Serializable;

@Data
public class ProductBean implements Serializable {
    private int id;//主键
    private String price;//价格
    private String information;//商品信息
    private String shopkeeper;//店家
    private int number;//付款数量
    private String img;//商品图片
}
