package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.UserDTO;


// HTML문서에서 input 태그를 이용하여 데이터를 받아오는 방식
@Controller
@RequestMapping("/param3")
public class ParamController3 {

	// get 방식 + localhost:8080/register
	// 사용자 등록폼을 반환하는 메소드
	@GetMapping("/register")
	public String ex1() {
		return "/param/register"; // HTML문서주소
	}
	
	
	// post 방식 + localhost:8080/register + 파라미터
	// 사용자 정보를 등록하는 메소드
	@ResponseBody  // 해당 어노테이션이 붙어있지 않으면 HTML문서를 반환하겠다는 뜻
	// 같은 구조라도 어노테이션의 유무에 따라 반환하는 내용이 다름 => 순수한 데이터를 반환
	@PostMapping("/register")
	public String ex2(UserDTO dto) {
		System.out.println("username = "+dto.getUsername()+", age=" + dto.getAge());
		
		return "ok";
	}
	// 두개 세트로 사용~!
	
	
}
