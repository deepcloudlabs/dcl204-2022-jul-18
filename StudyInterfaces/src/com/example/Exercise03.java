package com.example;

public class Exercise03 {
	public static void main(String[] args) {

	}
}

sealed interface Service permits ABC, XYZ {
	int fun();
}

final class ABC implements Service {

	@Override
	public int fun() {
		return 42;
	}
}

final class XYZ implements Service {
	
	@Override
	public int fun() {
		return 108;
	}
}