package com.example.spring.di02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.spring.common.BookService;
import com.example.spring.common.BookServiceImpl;

@Configuration
public class Di02Config {
	@Bean
	public BookService bookService() {
		return new BookServiceImpl();
	}
}
