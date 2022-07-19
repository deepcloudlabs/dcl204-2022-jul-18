package com.example.zoo.application;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

public class ZooApp {

	public static void main(String[] args) {
		var zoo = List.of(
		    new Spider(),
		    new Cat(),
		    new Fish("Free Willy"),
		    new Spider(),
		    new Cat("Garfield"),
		    new Fish("Nemo"),
		    new Spider(),
		    new Cat()
		);
		
		for (var animal : zoo) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet pet) {
				// var pet = (Pet) animal;
				pet.play();
			}
		}
		// outer loop
		var totalLegs = 0;
		for (var animal : zoo) {
			if (animal instanceof Pet) {
				totalLegs += animal.getLegs(); 
			}
		}	
		System.out.println("Total number of legs: %d".formatted(totalLegs));
		
		// Since Java SE 8: Functional Programming
		totalLegs =
		zoo.stream() // inner loop
		   //.filter( animal -> animal instanceof Pet)
		   //.filter( animal -> Pet.class.isInstance(animal) )
		   .filter( Pet.class::isInstance )
		   //.mapToInt( animal -> animal.getLegs())
		   .mapToInt(Animal::getLegs)
		   .sum();
		// one-liner
		totalLegs = zoo.stream().parallel().filter(Pet.class::isInstance).mapToInt(Animal::getLegs).sum();
		System.out.println("Total number of legs: %d".formatted(totalLegs));
		
		// Stream API + Functional Programming + Filter/Map/Reduce
		zoo.stream()
		   .collect(groupingBy(Animal::getClass,counting()))
		   .forEach((clazz,count) -> System.out.println("%s: %d".formatted(clazz.getSimpleName(),count))) ;
	}

}
