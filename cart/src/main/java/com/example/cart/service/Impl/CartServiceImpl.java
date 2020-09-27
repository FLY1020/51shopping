package com.example.cart.service.Impl;

import com.example.cart.bean.Cart;
import com.example.cart.bean.ProductBean;
import com.example.cart.mapper.CartMapper;
import com.example.cart.service.CartService;
import com.example.shopapi.pojo.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    //    用户添加一条商品
    @Override
    public int setCar(Cart cart) {
        return cartMapper.setCar(cart);
    }

    @Override
    public List<ProductBean> getUserCart(String username) {
        return cartMapper.getUserCart(username);
    }

    @Override
    public int delectPro(Cart cart) {
        return cartMapper.delectPro(cart);
    }

    @Override
    public int setOrder(order order) {
        return cartMapper.setOrder(order);
    }
}
