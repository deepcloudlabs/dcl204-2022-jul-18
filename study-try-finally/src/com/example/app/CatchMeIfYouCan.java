package com.example.app;

@SuppressWarnings("finally")
public class CatchMeIfYouCan {

	public static void main(String[] args) {
		System.err.println(fun());
	}

	public static int fun() {
		try {
			return 42;
		} finally {
			return 108;
		}
	}
}
