package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		// Integral Types: byte, short, int, long
		// signed
		byte b= 127; // 1-Byte [-128..127]
		b++;
		System.out.println("b=%d".formatted(b));
		b=-128;
		b--;
		System.out.println("b=%d".formatted(b));
		short s = 1; // 2-Byte [-32768..32767]
		s=Short.MAX_VALUE;
		System.out.println("s=%d".formatted(s));
		s++;
		System.out.println("s=%d".formatted(s));
		int x = 1; // 4-byte [-2147483648..2147483647]
		x = Integer.MAX_VALUE;
		System.out.println("x=%d".formatted(x));
		x++;
		System.out.println("x=%d".formatted(x));
		long l = Long.MAX_VALUE; // 8-byte [-9223372036854775808..9223372036854775807]
		System.out.println("l=%d".formatted(l));
		l++;
		System.out.println("l=%d".formatted(l));
		BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
		System.out.println("bi=%s".formatted(bi.toString()));
		bi = bi.add(BigInteger.ONE);
		System.out.println("bi=%s".formatted(bi.toString()));
		
		byte u = 127, v=1, z;
		z = (byte) (u + v);
		System.out.println("z=%d".formatted(z));
		
		// Ctrl + Shift + C
//		int inf = 1/0;
//		System.out.println("one=%d".formatted(inf));
		
		long ll = Integer.MAX_VALUE + 1L;
		System.out.println("ll=%d".formatted(ll));
		
		long nn = 12345 + 5432L;
		System.out.println("nn=%d".formatted(nn));
		
	}

}
