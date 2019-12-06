package com.org.shop;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan(basePackages = "com.org.shop.mapper")
public class ShopWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopWebApplication.class, args);
		log.info("this is ShopWebApplication start ..........");
	}

}
