package com.example.spring.di05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Di05MainJava {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Di05Config.class);
		SampleBean sampleBean = (SampleBean) ctx.getBean("sampleBean");
		System.out.println(sampleBean);
		((AnnotationConfigApplicationContext) ctx).close();
	}
}
