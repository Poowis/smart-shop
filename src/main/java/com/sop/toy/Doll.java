package com.sop.toy;

public class Doll implements Toy {

	private String name;
	private String category;
	private String subCategory;
	private String color;

	public Doll() {
		super();
	}

	public Doll(String name, String category, String subCategory, String color) {
		super();
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.color = color;
	}

	public void setColor(String color) {
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

	public String getColor() {
		return color;
	}

	@Override
	public void play() {
		System.out.println("I am playing with " + name);
	}

}
