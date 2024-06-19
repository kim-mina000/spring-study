package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	CommmentRepository repository;
	
	@Test
	public void 댓글등록() {
		Member member = Member.builder()
																	.password("1234")
																	.name("냐냐냐")
																	.id("냐냐")
																	.build();
		
		Board board = Board.builder()
											.writer(member)
											.no(3)
											.build();
											
		Comment comment = Comment.builder()
																				.board(board)
																				.content("눈나만나야쥥")
																				.writer(member)
																				.build();
		repository.save(comment);
	}
	
	@Test
	public void 댓글삭제() {
		repository.deleteById(4);
	}
	
	@Test
	public void 게시물별댓글조회() {
		Board board = Board.builder().no(4).build();
		List<Comment> list = repository.findByBoard(board);
		
		for (Comment comment : list) {
			System.out.println(comment);
		}
	}
	
	@Test
	public void 게시물별댓글삭제() {
		Board board = Board.builder().no(4).build();
		
		repository.deleteByBoard(board);
	}
}
