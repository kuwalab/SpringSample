package com.example.spring.aop01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring.common.BookService;

public class Aop01Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/aop/aop01.xml");
		BookService bookService = ctx.getBean(BookService.class);
		System.out.println(bookService.search("test"));
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
