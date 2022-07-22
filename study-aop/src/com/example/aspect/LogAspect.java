package com.example.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogAspect implements InvocationHandler {
	private final Object target;
	
	public LogAspect(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Method (%s) runs at (%s).".formatted(method.getName(),new Date()));
		var result = method.invoke(target, args);
		System.out.println("Method (%s) return %s.".formatted(method.getName(),result));		
		return result;
	}

}
