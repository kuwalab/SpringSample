package com.example.spring.di03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Di03MainJava {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Di03Config.class);
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		// singleton?
		Car car2_2 = (Car) ctx.getBean("car2");
		System.out.println(car2 == car2_2);
		((AnnotationConfigApplicationContext) ctx).close();
	}
}
