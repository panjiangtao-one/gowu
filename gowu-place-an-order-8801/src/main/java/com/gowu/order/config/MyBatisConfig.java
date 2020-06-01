package com.gowu.order.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:13
 */
@Configuration
@MapperScan({"com.gowu.order.dao"})
public class MyBatisConfig {


}
