package com.example.demo.repository;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;


@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	
	@Test
	public void 게시물30개추가() {
		for (int i=1; i<=30; i++) {
			Board board = Board.builder()
														.title(i+"번글")
														.content("Good~")
														.writer("♥")
														.build();
			repository.save(board);
		}
	}
	
	@Test
	public void 정렬조건추가하기() {
		// no 필드값을 기준으로 역정렬 regDate를 기준으로 정렬해도됨
		Sort sort = Sort.by("regDate").descending();
		
		// of메소드: PageRequest의 객체를 생성하는 함수
		Pageable pageable = PageRequest.of(0, 5,sort); // 페이지 번호, 데이터 개수, 정렬
		
		Page<Board> result = repository.findAll(pageable);
		
		List<Board> list = result.getContent();
		
		System.out.println(list);
	}

	@Test
	public void 페이지테스트() {

		
	}
}
