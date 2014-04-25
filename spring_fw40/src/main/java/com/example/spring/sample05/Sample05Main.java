package com.example.spring.sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample05Main {

	/**
	 * http://www.techscore.com/tech/Java/Others/Spring/3/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/sample05.xml");
		SampleBean sampleBean = (SampleBean) ctx.getBean("sampleBean");
		System.out.println(sampleBean);
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
