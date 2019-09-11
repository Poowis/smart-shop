package com.sop.toy;

public class ToyFactory {
	public Toy getToy(String toyType) {
		switch (toyType.toLowerCase()) {
		case "doll":
			return new Doll();
		default:
			return null;

		}
	}
}
