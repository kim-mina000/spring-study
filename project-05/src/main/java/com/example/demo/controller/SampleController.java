package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	// Controller 사용자 요청 처리 (비즈니스 로직) 서블릿 포함
	
	@GetMapping("/ex1") // /sample/ex1
	public void ex1() {
		// return type이 void: url 주소가 html 경로가 됨
		// return type이 String: html 주소를 직접 정할 수 있음
	}
	
	@GetMapping("/ex2") // /sample/ex2
	public void ex2(Model model) { // model 화면에 데이터를 전달하는 클래스
		model.addAttribute("msg","안녕하세요"); // 컨트롤러 -> 화면으로 전달
	}
	
	@GetMapping("/ex3")
	public void ex3(Model model) {
		model.addAttribute("msg1","안녕하세요");
		model.addAttribute("msg2","반가워요");
	}
}
