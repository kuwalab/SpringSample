package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionSpringConnect {

	public static void main(String... args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/spring/beans.xml");
		TransactionSpringService tss = (TransactionSpringService) context
				.getBean("transactionSpringService");
		Emp emp = new Emp();
		emp.setEmpNo(11);
		emp.setName("あいうえお");
		emp.setAge(30);
		tss.insert(emp);
	}
}
