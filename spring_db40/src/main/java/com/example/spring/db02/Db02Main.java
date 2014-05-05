package com.example.spring.db02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Db02Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/db02.xml");
		BookDao bookDao = ctx.getBean(BookDao.class);

		System.out.println("# insert前");
		for (Book book : bookDao.selectBookList()) {
			System.out.println(book);
		}

		Book insBook = new Book();
		insBook.setBookId(3);
		insBook.setBookName("Spring上級");
		insBook.setPrice(3980);
		bookDao.insert(insBook);
		System.out.println("# insert後");
		for (Book book : bookDao.selectBookList()) {
			System.out.println(book);
		}

		Book updBook = new Book();
		updBook.setBookId(1);
		updBook.setBookName("改訂版 Spring入門");
		updBook.setPrice(3990);
		bookDao.update(updBook);
		System.out.println("# update後");
		for (Book book : bookDao.selectBookList()) {
			System.out.println(book);
		}

		bookDao.delete(updBook);
		System.out.println("# delete後");
		for (Book book : bookDao.selectBookList()) {
			System.out.println(book);
		}
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
