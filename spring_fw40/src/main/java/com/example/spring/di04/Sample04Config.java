package com.example.spring.di04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Sample04Config {

	public Tire tire1() {
		return new Tire("30インチ");
	}

	public Tire tire2() {
		return new Tire("35インチ");
	}

	@Bean
	public Car car1() {
		return new Car("軽自動車", tire1());
	}

	@Bean
	public Car car2() {
		return new Car("普通自動車", tire2());
	}
}
