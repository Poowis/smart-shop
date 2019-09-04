package com.sop.doll;

public class DollFactory {

	private static int currentId = 0;

	public static Doll create() {
		return new Doll(currentId++, "teddy", "animal", "bear", "brown");
	}

	public static Doll create(String name, String category, String subCatergory, String color) {
		return new Doll(currentId++, name, category, subCatergory, color);
	}
}
