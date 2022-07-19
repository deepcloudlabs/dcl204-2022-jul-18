package com.example.zoo.domain;

public class Fish extends Animal implements Pet {

	private String name;

	public Fish(String name) {
		super(0);
		this.name = name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void play() {
		System.out.println("%s is playing now...".formatted(name));
	}

	@Override
	public void eat() {
		System.out.println("%s is eating now...".formatted(name));
	}

	@Override
	public void walk() {
		System.out.println("%s is swimming now...".formatted(name));
	}

}
