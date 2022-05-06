package com.spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");
		Calculator cal = (Calculator) context.getBean("proxyCal"); //id가 proxyCal인 빈에 접근합니다.
		cal.add(100, 20);
		System.out.println();
		cal.substract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divde(100, 20); //메서드 호출 전후에 어드바이스 빈이 적용됩니다.
	}

}
