package com.example;

public class Exercise02 {

	public static void main(String[] args) {
		DD o = new DD();
		System.out.println(o instanceof DD);
		System.out.println(o instanceof CC);
		// Error : System.out.println(o instanceof AA);
		System.out.println(o instanceof BB);
	}

}

abstract class AA {}
abstract class GG {}
interface BB {}
interface FF {}
abstract class CC {}

class DD extends CC implements BB, FF  {}