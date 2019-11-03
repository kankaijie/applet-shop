package com.org.shop;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.org.shop.mapper")
public class ShopUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopUserApplication.class, args);
		log.info("this is ShopUserApplication start ..........");
	}

}
