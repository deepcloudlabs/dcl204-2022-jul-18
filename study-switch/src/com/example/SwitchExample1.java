package com.example;

public class SwitchExample1 {

	public static void main(String[] args) {
		var weekDay = 3;
		var status = "unknown";
		switch (weekDay) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				status = "working";
				break;
			case 6:
			case 7:
				status = "resting";
				break;
			default:
				status = "unknown";
		}
		System.out.println(status);
	}

}
