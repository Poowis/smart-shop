package com.sop.toy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class DollCollection {

	private ArrayList<Doll> list;
	private String path;
	private static DollCollection instance;

	public DollCollection() {
		super();
	}

	public static DollCollection getInstance() {
		if (instance == null) {
			instance = new DollCollection();
		}
		return instance;
	}

	public void setPath(String path) {
		this.path = path;
		try {
			list = new Gson().fromJson(new FileReader(this.path), new TypeToken<ArrayList<Doll>>() {
			}.getType());
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			list = new ArrayList<Doll>();
		}
	}

	public void setList(ArrayList<Doll> list) {
		this.list = list;
	}

	public void saveToPath() {
		FileWriter writer;
		try {
			writer = new FileWriter(path);
			new Gson().toJson(list, writer);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Doll> getList() {
		return list;
	}

	public Doll getDoll(int index) {
		return list.get(index);
	}

	public Doll createDoll(Doll doll) {
		Doll newDoll = (Doll) new ToyFactory().getToy("Doll");
		newDoll.setName(doll.getName());
		newDoll.setCategory(doll.getCategory());
		newDoll.setSubCategory(doll.getSubCategory());
		newDoll.setColor(doll.getColor());
		list.add(newDoll);
		saveToPath();
		return newDoll;
	}

	public Doll removeDoll(int index) {
		Doll doll = list.remove(index);
		saveToPath();
		return doll;
	}

	public Doll updateDoll(int index, Doll doll) {
		list.set(index, doll);
		saveToPath();
		return doll;
	}

}
