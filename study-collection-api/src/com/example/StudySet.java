package com.example;

import java.util.HashSet;
import java.util.Set;

public class StudySet {

	public static void main(String[] args) {
		// i) Un-ordered -> cannot sort ii) unique
		Set<Integer> numbers = new HashSet<>();
		numbers.add(42);
		numbers.add(23);
		numbers.add(4);  
		numbers.add(16);
		numbers.add(23);
		numbers.add(8);
		numbers.add(23);
		numbers.add(15);
		numbers.add(42);
		System.out.println(numbers.contains(23)); // O(1)
	}

}
