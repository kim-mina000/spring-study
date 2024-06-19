package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CommentDTO;

@SpringBootTest
public class CommentServiceTest {

	@Autowired
	CommentService service;
	
	@Test
	public void 댓글등록() {
	
		CommentDTO dto =  CommentDTO.builder()
																						.commentNo(10)
																						.boardNo(2)
																						.content("간식?")
																						.writer("냐냐")
//																						.regDate(LocalDateTime.now())
//																						.modDate(LocalDateTime.now())
																						.build();
		
		service.register(dto);
	}
	
	@Test
	public void 게시물별댓글목록조회() {
		List<CommentDTO> list = service.getListByBoardNo(2);
		System.out.println(list);
	}
	
	@Test
	public void 댓글삭제() {
		service.remove(5);
	}
	
}
