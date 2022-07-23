package com.example;

import java.util.Arrays;

@SuppressWarnings("unused")
public class StudyArray {

	public static void main(String[] args) {
		int x = 42; // scalar
		int[] numbers = { 4, 8, 15, 16, 23, 42 }; // Heap
		System.out.println(numbers.length);
		int[] dizi;
		dizi = new int[6]; // Heap -> Zero
		dizi[0] = 4;
		dizi[1] = 8;
		dizi[2] = 15;
		dizi[3] = 16;
		dizi[4] = 23;
		dizi[5] = 42;
		int[] array;
		array = new int[] { 4, 8, 15, 16, 23, 42 }; // Heap -> Zero
		// System.out.println(array[6]); ArrayIndexOutOfBoudsException
		// How to print array content
		System.out.println(numbers);
		System.out.println(Arrays.toString(numbers));
		// Loop #1
		for (int i = 0; i < numbers.length; ++i)
			System.out.println(numbers[i]);
		// Loop #1 - var
		for (var i = 0; i < numbers.length; ++i)
			System.out.println(numbers[i]);
		// Loop #2 : Java SE 5 - for-each
		for (var number : numbers) // safe, sequential, read-only
			System.out.println(++number);
		var sum = 0;
		for (var number : numbers) {
			if (number%2 == 1) { // if it is odd
				var squared = number * number;
				sum += squared;
			}	
		}
			
		// Loop #3 : Java SE 8 -> Functional Programming
		sum = Arrays.stream(numbers) // Stream API + Filter/Map/Reduce -> ForkJoin Framework -> JobStealing Algorithm
				    .parallel() 
		            .filter(u -> u%2 == 1)
		            .map(y -> y*y)
		            .sequential()
		            .sum(); // Functional Programming: lazy-loading, functions?
		// C++20: Ranges -> C++23
	}

}
