package com.org.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class ShopAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopAdminApplication.class, args);
		log.info("this is ShopAdminApplication start .............");
	}

}
