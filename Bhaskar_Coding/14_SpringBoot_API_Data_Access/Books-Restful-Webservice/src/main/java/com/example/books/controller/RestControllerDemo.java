package com.example.books.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestControllerDemo {



	@GetMapping("/bhaskar")
	public String greetingByRestController() {
		return "Bhaskar welcome";
	}
}
