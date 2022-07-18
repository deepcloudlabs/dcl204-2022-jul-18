package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char c = 'x'; // 2-byte, unsigned, unicode
		System.out.println((char)(c+1));
		char x = '\u20ba';
		System.out.println(x);
	}

}
