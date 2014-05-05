package com.example.spring.db03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Db03Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/db03.xml");
		BookDao bookDao = ctx.getBean(BookDao.class);
		System.out.println("条件なし");
		for (Book book : bookDao.selectBookList()) {
			System.out.println(book);
		}

		System.out.println("よくわかる%で検索1");
		for (Book book : bookDao.searchBookList1("よくわかる")) {
			System.out.println(book);
		}

		System.out.println("よくわかる%で検索2");
		for (Book book : bookDao.searchBookList2("よくわかる")) {
			System.out.println(book);
		}

		System.out.println("よくわかる%で検索3");
		Book param = new Book();
		param.setBookName("よくわかる%");
		for (Book book : bookDao.searchBookList3(param)) {
			System.out.println(book);
		}
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
