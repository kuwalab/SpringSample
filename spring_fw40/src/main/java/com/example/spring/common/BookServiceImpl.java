package com.example.spring.common;

import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService {
	@Override
	public Book search(String name) {
		return new Book(1, "よくわかるSpring", 3000);
	}
}
