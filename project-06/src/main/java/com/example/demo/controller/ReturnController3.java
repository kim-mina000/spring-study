package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @controller + ResponseBody
@RequestMapping("/return3")
public class ReturnController3 {
	
	// @ResponseBody가 자동으로 적용됨
//	@ResponseBody
	@GetMapping("/ex1")
	public String ex1() {
		return "hi~!";
	}
	

	
}
