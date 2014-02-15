package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicSpringConnect {

	public static void main(String... args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/spring/beans.xml");
		BasicSpringService bsc = (BasicSpringService) context
				.getBean("basicSpringService");
		bsc.execute();
	}
}
