package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository  repository;
	
	@Test
	public void 게시물등록() {
		Member member = Member.builder().id("냐냐").build();
		for(int i = 0; i < 3; i++) {
			Board board = Board.builder().writer(member).content(i+"번째게시물").title("멍멍").build();
			repository.save(board);
		}
	}
}
