package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/method/q")
public class MappingQuiz1 {
	// 다른 종류의 메소드를 사용하기 때문에 같은 주소를 사용해도 지장없음
	
	@ResponseBody
//	@GetMapping("/q_get")
	@GetMapping
	public String q_get() {
		System.out.println("게시물 조회 🐾");
		return "ok";
	}
	
	@ResponseBody
//	@PutMapping("/q_put")
	@PutMapping
	public String q_put() {
		System.out.println("게시물 수정 🐾");
		return "ok";
	}
	@ResponseBody
//	@DeleteMapping("/q_remove")
	@DeleteMapping
	public String q_remove() {
		System.out.println("게시물 삭제 🐾");
		return "ok";
	}
	@ResponseBody
//	@PostMapping("/q_post")
	@PostMapping
	public String q_post() {
		System.out.println("게시물 등록 🐾");
		return "ok";
	}

}
