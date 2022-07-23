package com.example;

@SuppressWarnings("unused")
public class Question {
	public static void main(String[] args) {
		B b = new B();
	}
}

@SuppressWarnings("unused")
class A {
	private D d = new D();

	public A() {
		System.out.println("A's constructor");
	}
	
	int fun() {
		return 42;
	}
}

@SuppressWarnings("unused")
class B extends A {
//	private E e = new E();
	private int b = super.fun();
	public B() {
		System.out.println("B's constructor");
	}
}

class C {
	public C() {
		System.out.println("C's constructor");
	}
}

class D {
	public D() {
		System.out.println("D's constructor");
	}
}

@SuppressWarnings("unused")
class E {
	private C c = new C();

	public E() {
		System.out.println("E's constructor");
	}
}