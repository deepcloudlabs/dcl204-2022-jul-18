package com.example;

public class StudyFloatingPointTypes {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// IEEE-754
		float pi = 3.141516171819F; // 4-byte
		double y = 123.45; // 8-byte
		double money = 2.0;
		money = money - 1.10;
		System.out.println("%1.16f".formatted(money));
		float budget = 1_000_000_000;
		budget = budget + 50;
		System.out.println("%16.3f".formatted(budget));
		double u = (0.1 + 0.2) + 0.3;
		double v = 0.1 + (0.2 + 0.3);
		System.out.println("u==v ? "+(u==v));
		
		double one = 0./ 0;
		System.out.println("one=%f".formatted(one));
		System.out.println(Double.isNaN(one));
		
		double inf = 1/0.0;
		System.out.println("inf=%f".formatted(inf));
				
	}

}
