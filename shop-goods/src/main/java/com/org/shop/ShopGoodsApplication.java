package com.org.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ShopGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopGoodsApplication.class, args);
		log.info("this is ShopGoodsApplication start .............");
	}

}
