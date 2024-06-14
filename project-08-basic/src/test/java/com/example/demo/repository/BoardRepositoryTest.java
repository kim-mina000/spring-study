package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;


@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 게시물30개추가() {
		Member member = Member.builder()
																		.id("user1")
																		.build();
		for (int i=1; i<=30; i++) {
			Board board = Board.builder()
														.title(i+"번글")
														.content("Good~")
														.writer(member)
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
	public void 게시물조회() {
//		repository.findBy(writer, writer -> writer.getId() =="user1");
		
		// 쿼리가 내부적으로 join 처리됨
		Optional<Board> optional = repository.findById(11);
		
		Board board = optional.get();
		
		// 회원정보가 함께 출력됨
		System.out.println(board);
		
	}
	
	@Test
	public void 특정회원이작성한게시물삭제() {
		Member member = Member.builder().id("user1").build();
		
		repository.deleteWriter(member);
	}
}
