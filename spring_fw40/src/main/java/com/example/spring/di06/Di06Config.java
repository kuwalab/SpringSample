package com.example.spring.di06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Di06Config {
	@Bean
	@Scope("prototype")
	public Car car() {
		return new Car("軽自動車");
	}
}
