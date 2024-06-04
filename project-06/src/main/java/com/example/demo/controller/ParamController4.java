package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.BookDTO;


@Controller
@RequestMapping("/param4")
public class ParamController4 {
	
	// 이전까지는 url + 파라미터/ 패스밸류어블 형태로 담음
	// GET localhost:8080/param4/ex1+json
	@ResponseBody
	@GetMapping("/ex1")
	public String ex1(@RequestBody BookDTO dto) {
		System.out.println("메세지 바디에 담긴 json 객체 꺼내기: "+ dto);
		return "ok";
	}
	
	// GET localhost:8080/param4/ex2+json
	@ResponseBody
	@GetMapping("/ex2")
	public String ex2(@RequestBody ArrayList<BookDTO> list) {
		System.out.println("메세지 바디에 담긴 json 리스트 수집: "+list);
		return "ok";
	}
	
	
}
