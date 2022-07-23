package com.example;

public class C {
	private int x;
	private static int counter = 0;

	public static int getCounter() {
		return counter;
	}

	public C(int x) {
		this.x = x;
		counter++;
	}

	public int getX() {
		return this.x;
	}

}
