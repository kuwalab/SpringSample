package com.example.spring.sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Sample05MainJava {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Sample05Config.class);
		SampleBean sampleBean = (SampleBean) ctx.getBean("sampleBean");
		System.out.println(sampleBean);
	}
}
