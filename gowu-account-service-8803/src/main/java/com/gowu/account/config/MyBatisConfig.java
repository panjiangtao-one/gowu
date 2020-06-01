package com.gowu.account.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:13
 */
@Configuration
@MapperScan({"com.gowu.account.dao"})
public class MyBatisConfig {


}
