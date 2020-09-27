package com.example.order.service;

import com.example.order.bean.ProductBean;
import com.example.order.bean.order;

import java.util.List;

public interface OrderService {
    //查询未发货的订单
    public List<ProductBean> getOrder(order order);
}
