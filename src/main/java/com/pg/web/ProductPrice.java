package com.pg.web;

public class ProductPrice {

	protected Long id;
	
	protected Long productId;
	
	protected Double price;

	public ProductPrice() {
		super();
	}

	public ProductPrice(Long id, Long productId, Double price) {
		super();
		this.id = id;
		this.productId = productId;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductPrice [productPriceId=" + id + ", productId=" + productId + ", price=" + price + "]";
	}
}
