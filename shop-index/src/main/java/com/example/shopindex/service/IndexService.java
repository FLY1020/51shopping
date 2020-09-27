package com.example.shopindex.service;

import com.example.shopindex.bean.ProductBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndexService {
    //查询全部商品
    public List<ProductBean> getAllProduct();


}
