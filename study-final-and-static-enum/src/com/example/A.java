package com.example;

// final: 
// 1) field, parameter, local variable -> constant
// 2) class, method -> extensibility
@SuppressWarnings("unused")
public class A {
	private final int x = 42; // constant
	
	public void fun(final int y) { // y is constant
		final int z = 108; // constant
	}
	
	public final void sun() {}
}

class B extends A {
	
}