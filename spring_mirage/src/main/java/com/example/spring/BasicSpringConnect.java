package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicSpringConnect {

	public static void main(String... args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/spring/beans.xml");
		BasicSpringService bss = (BasicSpringService) context
				.getBean("basicSpringService");
		bss.execute();
	}
}
