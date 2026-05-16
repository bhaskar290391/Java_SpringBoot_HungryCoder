package com.example.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemo {

	@GetMapping("/greeting")
	@ResponseBody
	public String greeting() {
		return "Hello World ";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
