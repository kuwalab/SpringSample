package com.example.spring.di04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample04Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/di/di04.xml");
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
