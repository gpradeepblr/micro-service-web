package com.pg.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class RemoteProductRepository implements ProductRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String productServiceUrl;
	protected String productPriceServiceUrl;
	
	public RemoteProductRepository(String productServiceUrl, String productPriceServiceUrl) {
		this.productServiceUrl = productServiceUrl.startsWith("http") ? productServiceUrl
				: "http://" + productServiceUrl;
		this.productPriceServiceUrl = productPriceServiceUrl.startsWith("http") ? productPriceServiceUrl
				: "http://" + productPriceServiceUrl;
	}
	
	@Override
	public List<ProductDetails> getAllProducts() {
		ProductDetails[] productDetailsList = restTemplate.getForObject(productServiceUrl+"/products", ProductDetails[].class);
		ProductPrice[] productPriceDetailsList = restTemplate.getForObject(productPriceServiceUrl+"/productprices/", ProductPrice[].class);
		for (int i = 0; i < productDetailsList.length;i++) {
			for (int j = 0; j < productPriceDetailsList.length;j++) {
				if (productDetailsList[i].id == productPriceDetailsList[j].getProductId()) {
					productDetailsList[i].setPrice(productPriceDetailsList[j].getPrice());
				}
			}
		}
		
		return Arrays.asList(productDetailsList);
	}
}
