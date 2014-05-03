package com.example.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring.common.Book;
import com.example.spring.common.BookService;

public class Di02Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/di/di02.xml");
		BookService bookService = ctx.getBean(BookService.class);
		Book book = bookService.search("");
		System.out.println(book);
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
