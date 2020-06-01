package com.gowu.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: go-shopping
 * @description:
 * @author: Pjt
 * @create: 2020-06-01 22:39
 **/
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableFeignClients
//@EnableDiscoveryClient

@SpringBootApplication
public class account8803 {
    public static void main(String[] args) {
        SpringApplication.run(account8803.class);
    }
}
