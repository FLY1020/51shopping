package com.example.shopindex.service.Impl;

import com.example.shopindex.bean.ProductBean;
import com.example.shopindex.mapper.IndexMapper;
import com.example.shopindex.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Override
    public List<ProductBean> getAllProduct() {
        return indexMapper.getAllProduct();
    }
}
