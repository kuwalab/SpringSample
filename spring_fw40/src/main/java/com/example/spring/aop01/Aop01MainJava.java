package com.example.spring.aop01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.spring.common.BookService;

public class Aop01MainJava {

	/**
	 * http://www.techscore.com/tech/Java/Others/Spring/3/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Aop01Config.class);
		BookService bookService = ctx.getBean(BookService.class);
		System.out.println(bookService.search("test"));
		((AnnotationConfigApplicationContext) ctx).close();
	}
}
