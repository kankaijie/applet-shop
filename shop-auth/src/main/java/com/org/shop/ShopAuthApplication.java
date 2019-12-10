package com.org.shop;

import lombok.extern.java.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@Log
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.org.shop")
public class ShopAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopAuthApplication.class, args);
        log.info("this is ShopAuthApplication start ...........");
    }

}
