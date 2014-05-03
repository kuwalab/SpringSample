package com.example.spring.di03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Di03Config {
	@Bean
	public Car car1() {
		Car car = new Car("軽自動車");
		car.setColor("red");
		car.setPrice(1000000);

		return car;
	}

	@Bean
	public Car car2() {
		return new Car("普通自動車", "blue");
	}
}
