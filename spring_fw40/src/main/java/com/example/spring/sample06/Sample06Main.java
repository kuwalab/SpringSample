package com.example.spring.sample06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample06Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/sample06.xml");
		Car car1 = ctx.getBean(Car.class);
		System.out.println(car1);
		Car car2 = ctx.getBean(Car.class);
		System.out.println(car2);
		System.out.println("car1=car2: " + (car1 == car2));
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
