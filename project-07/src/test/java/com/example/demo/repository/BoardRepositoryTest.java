package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

// 리파지토리가 가지고 있는 기능을 단독으로 테스트하기 위함 

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	
	@Test
	public void 빈을가지고왔는지테스트() {
		System.out.println("repository의 주소: "+repository);
	}
	
	@Test
	void 게시물등록() {
		// 게시물 번호와 시간은 입력할 필요없음
		Board  board = Board.builder()
														.title("1번글")
														.content("내용입니다")
														.writer("둘리")
														.build();
		
		System.out.println("등록전: "+board.toString());
		repository.save(board);
		System.out.println("등록후: "+board.toString());
	}
	
	@Test
	void 게시물목록조회() {
		repository.findAll();
		System.out.println(repository.findAll());
	}
	
	@Test
	void 게시물단건조회() {
		repository.findById(0);
		System.out.println(repository.findById(3));
	}
	
	@Test
	void 게시물수정() {
		// 기존 게시물 정보를 꺼내와서 일부 변경
		Optional<Board> newContent = repository.findById(3);
		Board newBoard = newContent.get();
		newBoard.setContent("수정되었습니다");
		repository.save(newBoard); // 게시물 존재 유무에 따라 update/insert 알아서 분기함 id로 판별
	}
	
	@Test
	void 게시물삭제() {
		repository.deleteById(0);
	}
}
