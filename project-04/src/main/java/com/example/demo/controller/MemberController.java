package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;

// controller에서는 비즈니스 로직만 처리할것!
// mvc 모델2 버전 -> 컨트롤러(비즈니스로직)와 뷰(화면구성)가 나뉘어져있음
// 역할에 따라 나누자!가 mvc의 기본 방침
@Controller // 컨트롤러를 의미하는 어노테이션 + 빈으로 등록됨
@RequestMapping("/v2") // 사용자 요청을 /v2주소로 매핑(중간경로) 공통적으로 들어가는 경로는 여기표기
// 컨트롤러안에 여러개의 메소드를 만들수잇음
public class MemberController {
	MemberRepository memberRepository = new MemberRepository();
	
	// 회원 폼 메소드
	@GetMapping("/form") // 사용자 요청을 /form 주소로 매핑
	public String method1() {
		return "/v2/form";
	};
	
	// 회원 등록 메소드
	@PostMapping("/save") // 매개변수 앞에 어노테이션을 붙여줘야 매핑이됨
	public String method2(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model) {
		
		// 회원추가
		Member member = new Member(0, username, password);
		memberRepository.save(member);
		
		// 새로 추가한 회원 정보를 화면에 전달
		model.addAttribute("member", member);
		
		return"/v2/save"; //사용자에게 반환할 jsp파일의 경로
	};
	

}
