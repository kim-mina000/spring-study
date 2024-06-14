package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/lsit")
	public void 목록() {
		
	}
	
	@GetMapping("/register")
	public void 등록1() {
		
	}
	
	@PostMapping("/register")
	public String 등록2() {
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/read")
	public void 조회() {
		
	}
}
