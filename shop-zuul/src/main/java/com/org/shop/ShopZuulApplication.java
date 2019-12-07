package com.org.shop;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@Log
@EnableZuulProxy
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ShopZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopZuulApplication.class, args);
		log.info("this is ShopZuulApplication start ..............");
	}

}
