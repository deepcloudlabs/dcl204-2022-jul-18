package com.example;

import java.util.List;

@SuppressWarnings("unused")
public class StudyWrapperClasses {

	public static void main(String[] args) {
		// byte -> Byte
		// int -> Integer, char -> Character
		// Wrapper Classes -> Immutable
		int x = 42; // local variable + value-typed
		Integer y = 42; // local variable + reference
		Integer z = 42; // auto-boxing since java se 5
		Integer u = 549; // = Integer.valueOf(549);
		Integer v = Integer.valueOf(549);
		System.out.println("y==z ? " + (y == z)); // true
		System.out.println("u==v ? " + (u == v)); // false
		// Object Header (12-Byte) + int (4-Byte)
		// x: 4-Byte
		// y -> [16-byte]
		List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
		// List<int>: 6 x 4-byte = 24-byte
		// List<Integer> : 6 x 16-byte = 96-byte
		// List<Integer> --> List<int>
	}

}
