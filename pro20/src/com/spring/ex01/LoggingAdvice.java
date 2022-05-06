package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor { // 인터페이스 MethodInterceptor를 구현해 어드바이스 클래스를 만듭니다.
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전 : LoggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전"); //메서드 호출 전에 수행하는 구문입니다. 
		
		Object object = invocation.proceed(); // invocation을 이용해 메서드를 호출합니다.
		
		System.out.println("[메서드 호출 후 : loggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후"); // 메서드 호출 후에 수행하는 구문입니다.
		return object;
		
	}

}
