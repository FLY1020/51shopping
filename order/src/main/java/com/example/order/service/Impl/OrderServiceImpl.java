package com.example.order.service.Impl;

import com.example.order.bean.ProductBean;
import com.example.order.bean.order;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<ProductBean> getOrder(order order) {
        return orderMapper.getOrder(order);
    }
}
