package com.example.spring_security32;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/")
	public String index() {
		return "test/index";
	}
}
