package com.example.cart.mapper;

import com.example.cart.bean.Cart;
import com.example.cart.bean.ProductBean;
import com.example.shopapi.pojo.order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartMapper {

    //添加一个商品到购物车
    @Insert("insert into cart (username,productid) values(#{username},#{productid})")
    public int setCar(Cart cart);

    //查找用户购物车
    @Select("select * from product where id in (select productid from cart where username=#{username})")
    public List<ProductBean> getUserCart(String username);

    //    删除一个商品
    @Delete("delete from cart where username=#{username} and  productid=#{productid}")
    public int delectPro(Cart cart);

    //生成一个订单
    @Insert("insert into tb_order (username,productid,delivered) values(#{username},#{productid},#{delivered})")
    public int setOrder(order order);
}
