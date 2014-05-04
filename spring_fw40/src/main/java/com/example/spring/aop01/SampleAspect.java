package com.example.spring.aop01;

import org.aspectj.lang.ProceedingJoinPoint;

import com.example.spring.common.Book;

public class SampleAspect {
	public void before() {
		System.out.println("@Before");
	}

	public void after() {
		System.out.println("@After");
	}

	public void afterReturning(Book book) {
		System.out.println("@AfterReturning");
	}

	public Book around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("@Around begin");
		// 明示して呼び出さないといけない
		Book book = (Book) pjp.proceed();
		System.out.println("@Around end");
		return book;
	}

	public void afterThrowing(Throwable t) {
		System.out.println("@AfterThrowing");
	}
}
