package com.sop.doll;

import java.io.Serializable;

public class Doll implements Serializable {

	private int id;
	private String name;
	private String category;
	private String subCategory;
	private String color;

	public Doll(int id, String name, String category, String subCategory, String color) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.color = color;
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

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public int getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

}
