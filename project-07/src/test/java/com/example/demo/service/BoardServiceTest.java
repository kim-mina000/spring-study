package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {

//	BoardService service = new BoardService(); 
// 원래 이렇게 사용할때마다 생성해서 사용해야 하지만?
	// Autowired를 통해 하나만 생성한 뒤 공유해서 사용할수있게됨
	
	@Autowired
	BoardService service;
	
	@Test
	public void 게시물등록() {
		// 새로운 게시물 등록 로직
		// 1. DTO 생성
		BoardDTO dto = BoardDTO.builder()
																	.title("2번글")
																	.content("내용입니다")
																	.writer("또치")
																	.build();
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호: "+ no);
	}
	
	// MVC 구조에서 개발할때
	// C - S - R
	// V
	// 안에서부터 밖으로 구현
	// 1.Repository 2.Service 3.Controller 4.View
	
	@Test
	public void 목록조회() {
		List<BoardDTO> list = service.getList();
		System.out.println(list);
		for(BoardDTO board:list) {
			System.out.println(board);
		}
	}
}
