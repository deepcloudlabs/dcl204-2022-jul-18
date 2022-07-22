package com.example.service.business;

import com.example.service.Calculator;

public class StandardCalculator implements Calculator {
	private Calculator self=this;
	
	public void setProxy(Calculator proxy) {
		self=proxy;
	}
	
	@Override
	public double add(double x, double y) {
		return x+y;
	}

	@Override
	public double sub(double x, double y) {
		return x-y;
	}

	@Override
	public double mul(double x, double y) {
		var sum = 0.0;
		for (var i=0;i<y;i++)
			sum = self.add(sum,x);
		return sum;
	}

	@Override
	public double div(double x, double y) {
		return x/y;
	}

}
