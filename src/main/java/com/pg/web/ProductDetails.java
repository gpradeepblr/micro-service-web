package com.pg.web;

public class ProductDetails {

	protected Long id;
	
	protected String name;
	
	protected String category;
	
	protected Double price;

	public ProductDetails() {
		super();
	}

	public ProductDetails(Long id, String name, String category, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
}
