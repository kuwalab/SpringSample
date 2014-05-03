package com.example.spring.aop01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.spring.common.Book;

@Aspect
@Component
public class SampleAspectJava {
	@Before("execution(* search(String))")
	public void before() {
		System.out.println("@Before");
	}

	@After("execution(* search(String))")
	public void after() {
		System.out.println("@After");
	}

	@AfterReturning(value = "execution(* search(String))", returning = "book")
	public void afterReturning(Book book) {
		System.out.println("@AfterReturning");
	}

	@Around("execution(* search(String))")
	public Book around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("@Around begin");
		// 明示して呼び出さないといけない
		Book book = (Book) pjp.proceed();
		System.out.println("@Around end");
		return book;
	}

	@AfterThrowing(value = "execution(* search(String))", throwing = "t")
	public void afterThrowing(Throwable t) {
		System.out.println("@AfterThrowing");
	}
}
