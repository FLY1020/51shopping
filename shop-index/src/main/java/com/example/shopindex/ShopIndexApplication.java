package com.example.shopindex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource(locations = {"classpath:provider.xml"})
@MapperScan(value = "com.example.shopindex.mapper")//批量扫描所有的接口
public class ShopIndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopIndexApplication.class, args);
    }

}
