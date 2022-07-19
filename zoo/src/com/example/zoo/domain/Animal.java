package com.example.zoo.domain;

abstract public class Animal {
	protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}

	public void walk() {
		System.out.println("Animal with %d legs is walking now...".formatted(legs));
	}

	abstract public void eat();
}
