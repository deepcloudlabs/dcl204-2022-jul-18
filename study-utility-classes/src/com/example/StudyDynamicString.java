package com.example;

public class StudyDynamicString {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String name = "jack"; // immutable
		int result = 42;
		// StringBuilder: not thread-safe
		// StringBuffer: thread-safe
		StringBuffer message = new StringBuffer(388888890);
		var start = System.currentTimeMillis();
		for (var i=0;i<50_000_000;++i)
			message.append(i);
		var stop = System.currentTimeMillis();
		System.out.println(message.length());
		System.err.println("Duration: %d".formatted(stop-start));
	}

}
