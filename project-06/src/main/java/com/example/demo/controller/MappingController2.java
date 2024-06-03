package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 클래스 레벨에 붙이면 중간경로
@RequestMapping("/board")
@Controller
public class MappingController2 {

	// GET localhost:8080/board/list
	// 메소드 레벨에 붙이면 마지막 경로
	
	@ResponseBody
	@GetMapping("/list")
	public String list() {
		System.out.println("게시물 조회 . . .");
		return "ok";
	}
	
	// Post localhost:8080/board/save
	@ResponseBody
	@PostMapping("/save")
	public String save() {
		System.out.println("게시물 등록 . . .");
		return "ok";
	}
	
	// Put localhost:8080/board/modify
	@ResponseBody
	@PutMapping("/modify")
	public String modify() {
		System.out.println("게시물 수정 . . .");
		return "ok";
	}
	
	// Delet localhost:8080/board/remove
	@ResponseBody
	@DeleteMapping("/remove")
	public String remove() {
		System.out.println("게시물 삭제 . . .");
		return "ok";
	}
}
