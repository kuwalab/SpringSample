package com.example.spring_security32;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test/")
	public String index() {
		return "test/index";
	}

	@RequestMapping("/sample/")
	public String sample() {
		return "sample/index";
	}
}
