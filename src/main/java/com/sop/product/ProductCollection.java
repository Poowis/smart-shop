package com.sop.product;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductCollection {

	private int currentId = 0;

	private String name;
	private ArrayList<HashMap<String, Object>> list;

	public ProductCollection(String name) {
		super();
		this.name = name;
		list = new ArrayList<HashMap<String, Object>>();
	}

	public void add(Product product) {
		HashMap<String, Object> temp = new HashMap<String, Object>();
		temp.put(name + "Id", currentId++);
		temp.put(name, product);
		list.add(temp);
	}

	private int getIndex(int id) {
		for (int i = 0; i < list.size(); i++) {
			if ((int) list.get(i).get(name + "Id") == id) {
				return i;
			}
		}
		return -1;
	}
	
	public Product get(int id) {
		int index = getIndex(id);
		if (index > -1) {
			return (Product) list.get(index).get("product");
		}
		return null;
	}

	public Product pop(int id) {
		int index = getIndex(id);
		if (index > -1) {
			return (Product) list.remove(index).get("product");
		}
		return null;
	}

	public ArrayList<HashMap<String, Object>> getList() {
		return list;
	}

}
