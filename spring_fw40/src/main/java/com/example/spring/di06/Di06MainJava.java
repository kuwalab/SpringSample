package com.example.spring.di06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Di06MainJava {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Di06Config.class);
		Car car1 = ctx.getBean(Car.class);
		System.out.println(car1);
		Car car2 = ctx.getBean(Car.class);
		System.out.println(car2);

		System.out.println("car1=car2: " + (car1 == car2));

		((AnnotationConfigApplicationContext) ctx).close();
	}
}
