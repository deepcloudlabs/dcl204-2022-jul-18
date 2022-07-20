package com.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		// i) Ordered -> sort ii) Allow duplicate
		List<Integer> numbers = new LinkedList<>();
		int life = 42;
		numbers.add(life);
		numbers.add(23);
		numbers.add(4);  // [42, 23, 4]
		numbers.add(0,8); // [42, 8, 23, 4]
		numbers.add(23);
		numbers.add(23);
		numbers.add(23);
		numbers.add(23);
		numbers.add(23);
		numbers.add(23);
		numbers.remove(0);
		System.out.println(numbers.get(2));
		Comparator<Integer> ascendingOrder = Integer::compare;
		Comparator<Integer> decendingOrder = ascendingOrder.reversed();
		numbers.sort(decendingOrder);
		numbers.sort((x,y)->y-x); // partial order
		System.out.println(numbers);
		System.out.println(numbers.contains(1));
	}

}
