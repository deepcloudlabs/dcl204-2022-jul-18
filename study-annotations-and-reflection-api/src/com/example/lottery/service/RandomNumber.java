package com.example.lottery.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomNumber {

	int min();

	int max();

	boolean distinct();

	boolean sorted();

	int size();

}
