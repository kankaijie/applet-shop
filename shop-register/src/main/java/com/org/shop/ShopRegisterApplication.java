package com.org.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShopRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopRegisterApplication.class, args);

		System.out.println("this is ShopRegisterApplication start ............");
	}

}
