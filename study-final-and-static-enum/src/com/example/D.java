package com.example;

import static com.example.C.getCounter;

public class D {
	@SuppressWarnings({ "static-access", "null" })
	public static void main(String[] args) {
		System.err.println(getCounter());
		var c = new C(100);
		System.err.println(getCounter());
		System.err.println(c.getCounter());
		C p = null;
		System.err.println(p.getCounter());
		System.err.println(p.getX());
	}
}
