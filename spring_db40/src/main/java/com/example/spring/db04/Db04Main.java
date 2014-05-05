package com.example.spring.db04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Db04Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/db04.xml");
		BookDao bookDao = ctx.getBean(BookDao.class);
		System.out.println("selectByKey1: " + bookDao.selectByKey(1));
		System.out.println("count: " + bookDao.count("よくわかる"));
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
