package com.example.shopindex.mapper;


import com.example.shopindex.bean.ProductBean;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


//指定这是一个操作数据库的mapper
@Mapper
public interface IndexMapper {

    //查询所有商品
    @Select("SELECT * FROM product")
    public List<ProductBean> getAllProduct();

}
