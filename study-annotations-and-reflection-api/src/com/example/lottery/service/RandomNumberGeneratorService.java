package com.example.lottery.service;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGeneratorService {

	public void generate(Object o) {
		var clazz = o.getClass();
		for (var field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				var randomNumberAnnotation = field.getAnnotation(RandomNumber.class);
				var min = randomNumberAnnotation.min();
				var max = randomNumberAnnotation.max();
				var size = randomNumberAnnotation.size();
				var streamOfNumbers = ThreadLocalRandom.current().ints(min, max);
				if (randomNumberAnnotation.distinct())
					streamOfNumbers = streamOfNumbers.distinct();

				streamOfNumbers = streamOfNumbers.limit(size);
				if (randomNumberAnnotation.sorted())
					streamOfNumbers = streamOfNumbers.sorted();
				var numbers = streamOfNumbers.boxed().toList();
				try {
					field.setAccessible(true);
					field.set(o, numbers);
					field.setAccessible(false);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.err.println("Error: %s".formatted(e.getMessage()));
				}
			}
		}
	}
}
