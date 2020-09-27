package com.example.cart.service;

import com.example.cart.bean.Cart;
import com.example.cart.bean.ProductBean;
import com.example.shopapi.pojo.order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartService {
    //添加一个商品到购物车
    public int setCar(Cart cart);

    //读取用户购物车数据
    public List<ProductBean> getUserCart(String username);

    //    删除一个商品
    public int delectPro(Cart cart);

    //生成一个订单
    public int setOrder(order order);

}
