package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;


@RestController // @Controller + @ResponseBody
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;
	
	@GetMapping("/list") // 게시물별 댓글 목록 조회
	public List<CommentDTO> list (@RequestParam(name = "boardNo") int boardNo){
		List<CommentDTO> commentList = service.getListByBoardNo(boardNo);
		return commentList;
	}
	
	// 새로운 댓글 등록
	@PostMapping("/register")
	public Boolean Register(CommentDTO dto) {
		// 시큐리티 처리 이전이기 때문에 임시아이디로 등록!
		String id= "냐냐";
		dto.setWriter(id);
		service.register(dto);
		
		return true;
	}
	
	// 특정 댓글 삭제
	@DeleteMapping("/remove")
	public Boolean remove(@RequestParam(name = "commentNo") int commentNo) {
		boolean result = service.remove(commentNo);
		return result;
	}
	
}
