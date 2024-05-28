package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz1")
public class QuizController {
	
	@GetMapping("/q1")
	public String method1() {
		return "/quiz1/q1";
	}
	
	@GetMapping("/q2")
	public String method2() {
		return "/quiz1/q2";
	}


}
