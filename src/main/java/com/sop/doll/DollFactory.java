package com.sop.doll;

public class DollFactory {

	private static int currentId = 0;
	
	public static Doll create() {
		return new Doll(currentId++, "teddy", "animal", "bear");
	}
}
