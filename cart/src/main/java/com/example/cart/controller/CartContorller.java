package com.example.cart.controller;

import com.example.cart.bean.Cart;
import com.example.cart.bean.ProductBean;
import com.example.cart.mapper.CartMapper;
import com.example.cart.service.CartService;
import com.example.shopapi.pojo.order;
import com.example.shopapi.service.SessionUserService;
import com.sun.javafx.fxml.builder.JavaFXFontBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CartContorller {


    @Autowired
    CartService cartService;

    @Autowired
    SessionUserService sessionUserService;

    Map<String, Object> map = new HashMap<>();

    //    用户添加一条商品
    @RequestMapping("cart/setpro")
    public Map<String, Object> setCart(HttpServletResponse response, Cart cart) {
        response.addHeader("Access-Control-Allow-Origin", "*");


        int i = cartService.setCar(cart);
        if (i > 0) {
            map.put("success", true);
        } else {
            map.put("success", false);
        }

        return map;
    }

    //    读取用户所有购物车商品
    @RequestMapping("cart/usercart")
    public Map<String, Object> getUser(HttpServletResponse response, String username) {
        response.addHeader("Access-Control-Allow-Origin", "*");


        List<ProductBean> productBeans = cartService.getUserCart(username);
        for (ProductBean p : productBeans) {

        }
        if (productBeans.size() > 0) {
            map.put("success", true);
            map.put("msg", productBeans);
        } else {
            map.put("success", false);
        }

        return map;
    }


    //    查询用户是否登录，从login模块获取session
    @GetMapping("cart/session")
    public Map<String, Object> getSession(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");


        if (sessionUserService.getSession() != null) {
            map.put("success", true);
            map.put("msg", sessionUserService.getSession());
        } else {
            map.put("success", false);
        }
        return map;
    }


    //    删除商品
    @PostMapping("cart/delectpro")
    public Map<String, Object> delectPro(HttpServletResponse response, Cart cart) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        if (cartService.delectPro(cart) > 0) {
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;
    }

    //    生成一条订单
    @PostMapping("cart/addorder")
    public Map<String, Object> addOrder(HttpServletResponse response, order oeder) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        System.out.println(oeder);
        if (cartService.setOrder(oeder) > 0) {
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;
    }

}
