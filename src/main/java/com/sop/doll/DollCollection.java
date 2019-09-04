package com.sop.doll;

import java.util.ArrayList;
import java.util.List;

public class DollCollection {

	private List<Doll> list;

	public DollCollection() {
		list = new ArrayList<Doll>();
	}

	public List<Doll> getList() {
		return list;
	}

	public void add(Doll doll) {
		list.add(doll);
	}
	
	public boolean removeById(int id) {
		return list.removeIf(doll -> (doll.getId() == id));
	}

}
