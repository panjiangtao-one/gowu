package com.gouwu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: go-shopping
 * @description:
 * @author: Pjt
 * @create: 2020-06-01 20:22
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain8800 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8800.class,args);
    }
}
