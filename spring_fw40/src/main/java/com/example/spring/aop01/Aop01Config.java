package com.example.spring.aop01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.example.spring.common",
		"com.example.spring.aop01" })
@EnableAspectJAutoProxy
public class Aop01Config {

}
