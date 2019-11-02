package com.org.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShopZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopZuulApplication.class, args);
	}

}
