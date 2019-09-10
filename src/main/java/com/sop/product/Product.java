package com.sop.product;

import java.io.Serializable;

public class Product implements Serializable {

	private Object product;
	private String status;
	private double price;

	public Product(Object product, String status, double price) {
		super();
		this.product = product;
		this.status = status;
		this.price = price;
	}

	public Object getProduct() {
		return product;
	}

	public void setProduct(Object product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
