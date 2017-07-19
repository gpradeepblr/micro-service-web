package com.pg.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class WebApplication {
	
	public static final String PRODUCT_SERVICE_URL = "http://PRODUCT-MICROSERVICE";
	public static final String PRODUCTPRICE_SERVICE_URL = "http://PRODUCTPRICE-MICROSERVICE";

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ProductRepository productRepository(){
		return new RemoteProductRepository(PRODUCT_SERVICE_URL, PRODUCTPRICE_SERVICE_URL);
	}
}
