package com.example;

public class StudyString {

	public static void main(String[] args) {
		// Immutable
		String name1 = new String("jack"); // GC -> Heap
		String name2 = "jack"; // Constant/Object Pool
		String name3 = "jack";
		name1 = name1.intern();
		System.out.println("name1==name2 ? "+(name1==name2)); // false
		System.out.println("name1==name2 ? "+(name1.equals(name2))); // true
		System.out.println("name3==name2 ? "+(name3==name2)); // true
		name3 = name3.toUpperCase();
		System.out.println("name3=%s".formatted(name3));

	}

}
