package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.BookDTO;



@Controller
@RequestMapping("/return2")
public class ReturnController2 {
	
	@ResponseBody
	@GetMapping("/ex1")
	public String ex1() {
		return "Hi~"; // text로 반환됨
	}
	
	@ResponseBody
	@GetMapping("/ex2")
	public int ex2() {
		return 100; // text로 반환됨
	}
	
	@ResponseBody
	@GetMapping("/ex3")
	public BookDTO ex3() {
		BookDTO bookDTO = new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000);
		return bookDTO; // class -> json
	}
	
	@ResponseBody
	@GetMapping("/ex4")
	public List<BookDTO> ex4() {
		List<BookDTO> list = new ArrayList<>();
		list.add(new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000));
		list.add(new BookDTO("스프링부트웹프로젝트","구멍가게코딩단",15000));
		list.add(new BookDTO("모두의 리눅스","길벗출판사",30000));
		return list; // class -> json
	}
	
	// ResponseEntity : 응답코드와 데이터를 담는 클래스
	// 보통은 프로그램에서 응답코드를 선정하지만! 개발자가 직접 응답코드를 선택해야하는 경우에 사용
	// @ResponseBody 생략해도됨
	@GetMapping("/ex5")
	public ResponseEntity ex5() {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR); // 200 ok 성공코드// INTERNAL_SERVER_ERROR 강제로 에러를 조작
	}
	
	// @ResponseBody
	@GetMapping("/ex6")
	public ResponseEntity<String> ex6() {
		return new ResponseEntity<>("success..", HttpStatus.OK); // 200 ok 성공코드 + 문자열
		// 											body에 들어가는 data , header(메타데이터)에 들어가는 코드
	}
	
	// @ResponseBody
	@GetMapping("/ex7")
	public ResponseEntity<BookDTO> ex7() {
		BookDTO bookDTO = new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000);
		return new ResponseEntity<>(bookDTO, HttpStatus.OK); // 200 ok 성공코드 + book 객체
	}
	
	
	
	
}
