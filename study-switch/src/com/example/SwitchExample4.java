package com.example;

public class SwitchExample4 {

	public static void main(String[] args) {
		var weekDay = 3;
		var status = switch (weekDay) {
			case 1, 2, 3, 4, 5 -> "working";
			case 6, 7 -> "resting";
			default -> "unknown";
		} ;
		System.out.println(status);
	}  

}
