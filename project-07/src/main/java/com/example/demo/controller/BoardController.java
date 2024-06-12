package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

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
	
	@Autowired
	BoardService service;
	
	// 메인화면을 반환하는 메소드
	@GetMapping("/main")
	public void main() {
	}
	
	// 목록화면
	@GetMapping("/list")
	public void list(Model model) {
		
		List<BoardDTO> list = service.getList();
		model.addAttribute("list", list);
	};
	
	// 등록화면을 반환하는 메소드
	@GetMapping("/register")
	public void register() {
	};
	
	
	// 1.dto: 폼에서 전달받은 게시물 정보 = 파라미터
	// 2.RedirectAttributes:다른 주소로 리다이렉트할때 화면에 데이터를 전달하는 객체 = Model
	// 컨트롤러에서 뷰로 데이터를 물고가는놈!

	// 등록을 처리하는 메소드
	@PostMapping("/register")
		public String 등록처리(BoardDTO dto, RedirectAttributes redirectAttributes) {
		
			// 게시물 등록하고 새로운 게시물 번호 반
			int no = service.register(dto);
			
			// 리다이렉트된 페이지(목록화면)에 새로운 게시물 번호 전달
			redirectAttributes.addFlashAttribute("msg",no);
		
			// 게시물 목록 화면으로 리다이렉트 하기
			// 리다이렉트? 새로운 URL을 다시 호출하는 것 
		return "redirect:/board/list"; // HTML파일x URL주소o
	}
	
	// 단건게시물 조회
	@GetMapping("/read")
	public void read(@RequestParam(name= "no") int no, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto",dto);
	}
	
	// 주소: Localhost:8080/board/modify?no=1
	// 게시물 수정, 수정화면을 반환하는 메소드
	@GetMapping("/modify")
	public void modify(@RequestParam(name="no") int no, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto",dto); // 화면에 특정 게시물 정보를 전달
	}
	
//	 수정 처리 메소드
	@PostMapping("/modify")
	public String postModify(BoardDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto); // 게시물 수정
		
		// addFlashAttribute() : 리다이렉트할 화면에 데이터를 보내는 함수
		// addAttribute() : 리다이렉트 주소에 파라미터를 추가하는 함수		// /board/read?no=1
		redirectAttributes.addAttribute("no",dto.getNo());
		
		// 상세화면으로 이동
		return "redirect:/board/read";
	}
	
	// 삭제 처리 메소드
	@PostMapping("/remove")
	public String remove(BoardDTO dto, RedirectAttributes redirectAttributes) {
		service.remove(dto);
		return "redirect:/board/list";
	}
}
