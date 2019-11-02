package com.org.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class ShopOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopOrderApplication.class, args);
		log.info("this is ShopOrderApplication start ..............");
	}

}
