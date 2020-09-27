package com.example.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;


@MapperScan(value = "com.example.login.mapper")//批量扫描所有的接口
@SpringBootApplication
@ImportResource(locations = {"classpath:login.xml"})//扫描xml
public class LoginApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LoginApplication.class, args);

    }

}
