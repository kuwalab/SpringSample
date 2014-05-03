package com.example.spring.di01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.spring.common.Book;
import com.example.spring.common.BookService;

public class Di01MainJava {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Di01Config.class);
		BookService bookService = ctx.getBean(BookService.class);
		Book book = bookService.search("");
		System.out.println(book);
		((AnnotationConfigApplicationContext) ctx).close();
	}
}
