package com.example.spring.sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Sample03MainJava {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Sample03Config.class);
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
	}
}
