package com.example.shopindex.controller;

import com.example.shopapi.service.SessionUserService;
import com.example.shopindex.bean.ProductBean;
import com.example.shopindex.mapper.IndexMapper;
import com.example.shopindex.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @Autowired
    SessionUserService sessionUserService;

    Map<String, Object> map = new HashMap<>();

    //查询全部数据接口
    @GetMapping("index/product")
    public Map<String, Object> getUser(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<ProductBean> productBeans = indexService.getAllProduct();
        //判断请求数据结果
        if (productBeans.size() > 0) {
            map.put("success", true);
            map.put("msg", productBeans);

        } else {
            map.put("success", false);
        }

        return map;
    }

    //    查询用户是否登录，从login模块获取session
    @GetMapping("index/session")
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
