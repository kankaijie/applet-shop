package com.org.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class ShopRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopRegisterApplication.class, args);

		System.out.println("this is ShopRegisterApplication start ............");
	}

}
