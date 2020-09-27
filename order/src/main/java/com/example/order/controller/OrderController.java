package com.example.order.controller;

import com.example.order.bean.ProductBean;
import com.example.order.bean.order;
import com.example.order.service.OrderService;
import com.example.shopapi.service.SessionUserService;
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
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    SessionUserService sessionUserService;

    Map<String,Object> map=new HashMap<>();

    //    用户添加一条商品
    @RequestMapping("order/getUserOder")
    public Map<String, Object> setCart(HttpServletResponse response, order order) {
        response.addHeader("Access-Control-Allow-Origin", "*");

//        System.out.println(order);

        List<ProductBean> productBeans=orderService.getOrder(order);

        for (ProductBean p:productBeans){
            System.out.println(p);
        }

        map.clear();
        if (productBeans.size()>0) {
            map.put("success", true);
            map.put("msg", productBeans);
        } else {
            map.put("success", false);
        }

        return map;
    }


    //    查询用户是否登录，从login模块获取session
    @GetMapping("order/session")
    public Map<String, Object> getSession(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        System.out.println(sessionUserService.getSession());
        if (sessionUserService.getSession() != null) {
            map.put("success", true);
            map.put("msg", sessionUserService.getSession());
        } else {
            map.put("success", false);
        }
        return map;
    }
}
