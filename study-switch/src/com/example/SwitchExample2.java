package com.example;

public class SwitchExample2 {

	public static void main(String[] args) {
		var weekDay = 3;
		var status = "unknown";
		switch (weekDay) {
			case 1, 2, 3, 4, 5 -> {
				status = "working";
			}
			case 6, 7 -> {
				status = "resting";
			}
			default -> {
				status = "unknown";
			}
		}
		System.out.println(status);
	}

}
