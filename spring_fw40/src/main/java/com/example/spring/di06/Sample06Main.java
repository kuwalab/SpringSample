package com.example.spring.di06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample06Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/di/di06.xml");
		Car car1 = ctx.getBean(Car.class);
		System.out.println(car1);
		Car car2 = ctx.getBean(Car.class);
		System.out.println(car2);
		System.out.println("car1=car2: " + (car1 == car2));
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
