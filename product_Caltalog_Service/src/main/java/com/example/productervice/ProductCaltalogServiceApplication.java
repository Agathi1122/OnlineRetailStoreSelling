package com.example.productervice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductCaltalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCaltalogServiceApplication.class, args);
	}

}
