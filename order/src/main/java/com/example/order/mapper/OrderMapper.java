package com.example.order.mapper;


import com.example.order.bean.ProductBean;
import com.example.order.bean.order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    //查询未发货的订单
    @Select("select product.*,delivered from product ,tb_order where product.id=tb_order.productid and tb_order.username=#{username}")
    public List<ProductBean> getOrder(order order);

    //    删除一个商品
    @Delete("delete from cart where username=#{username} and  productid=#{productid}")
    public int delectOrder(order order);


}
