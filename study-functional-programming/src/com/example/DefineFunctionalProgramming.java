package com.example;

import java.util.List;
import java.util.function.Predicate;

public class DefineFunctionalProgramming {

	public static void main(String[] args) {
		// fp's function: 1) higher-order function 
		//                2) pure function -> immutable -> 
		//                                   i. Lambda Expression
		//                                  ii. Method Reference
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		// even -> cube -> sum
		// New Type: function -> functional interface -> Single Abstract Method
		MyFun x = u -> 2 * u - 5 ; 
		
		// Build-in Functional Interface: Predicate, Function, ...
		Predicate<Integer> isEven = z -> z%2 == 0;
		var result =
		numbers.stream()
		       //.filter(z -> z%2 ==0)  // 4  8    16   42
		       .filter(MyFun::ciftMi)  // 4  8    16   42
		       //.mapToInt(p -> p*p*p)        // 64 512  4096 74088
		       .mapToInt(MyFun::kubu)        // 64 512  4096 74088
		       // (0,64) -> 64 -> (64,512) -> 576 -> (576,4096) -> 4672 -> (4672,74088) -> 78760
 		       //.reduce(0, (s,r)->s+r); 
		       //.reduce(0, Integer::sum);
		       .sum();
		System.out.println(result);
	}

}

@FunctionalInterface
interface MyFun {
	int fun(int x);
	static boolean ciftMi(int x) { return x%2 == 0;}
	static int kubu(int x) {return x*x*x;}
}