package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	/*
	 * 데이터 형식: HTML문서 or 순수한 데이터 
	 * 스프링부트는 기본적으로 HTML문서를 반환 
	 * 리턴타입 void or String 
	 * void :url 주소가 파일의 경로 
	 * String : 파일의 경로를 직접 작성
	 */
	@GetMapping("/main")
	public void main() {
	}
}
