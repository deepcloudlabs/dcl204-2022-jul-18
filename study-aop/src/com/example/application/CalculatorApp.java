package com.example.application;

import java.lang.reflect.Proxy;

import com.example.aspect.LogAspect;
import com.example.aspect.ProfilingAspect;
import com.example.service.Calculator;
import com.example.service.business.StandardCalculator;

public class CalculatorApp {

	public static void main(String[] args) {
		var standardCalculator = new StandardCalculator();
		var clazz = standardCalculator.getClass();
			Calculator calculator = (Calculator) Proxy.newProxyInstance(
					clazz.getClassLoader(), 
					clazz.getInterfaces(), 
					new LogAspect(standardCalculator)
			);
		calculator = (Calculator) Proxy.newProxyInstance(
				clazz.getClassLoader(), 
				clazz.getInterfaces(), 
				new ProfilingAspect(calculator)
				);
		standardCalculator.setProxy(calculator);
		System.err.println(calculator.getClass().getName());
//		System.out.println("3 + 5 = %f.".formatted(calculator.add(3, 5)));
//		System.out.println("3 - 5 = %f.".formatted(calculator.sub(3, 5)));
		System.out.println("3 * 5 = %f.".formatted(calculator.mul(3, 5)));
//		System.out.println("3 / 5 = %f.".formatted(calculator.div(3, 5)));
	}

}
