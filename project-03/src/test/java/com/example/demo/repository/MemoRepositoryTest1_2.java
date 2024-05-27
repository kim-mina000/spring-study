package com.example.demo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
// Pageable이 자동으로 입포트 안되서 쓰겟습니당
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

@SpringBootTest
public class MemoRepositoryTest1_2 {
	
	@Autowired
	MemoRepository repository;
	
	@Test
	void 메모데이트100개등록() {
		
		// IntStream 스트림
		// rangeClosed 특정 범위의 숫자들로 스트림을 생성하는 함수
		// forEach 특정 작업을 수행하는 함수
		IntStream.rangeClosed(1, 100).forEach(value -> System.out.println(value));
		
		//	void accept (int value) {
		//		System.out.println(value);
		//	} // 람다식으로 바꿔서 forEach()안에 넣기
		
		
		// 메모 100개를 생성해서 테이블에 추가
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Memo memo = Memo.builder().text("Sample..." + i).build();
			repository.save(memo);
		});
		
//		void accpet(int i) {
//			Memo memo = Memo.builder().text("Sample..." + i).build();
//			repository.save(memo);
//		} // 람다식으로 바꿔서 forEach()안에 넣기
		
	}
	@Test
	void 페이징처리() {
		// 페이지 생성
		Pageable pageable = PageRequest.of(0,10);
		
		// 페이지 정보를 전달하여 목록 조회
		Page<Memo> page = repository.findAll(pageable);
		// Page라는 클래스는 엔티티와 List를 함께 가지고있음 그중에
		// 리스트만 꺼내고 싶다면 ? ↓↓↓ 따로 만들어서 꺼내오기
		
		// 페이지 객체에서 엔티티 리스트 꺼내기
		List<Memo> list = page.getContent();
		
		System.out.println(list);
		
		// 페이지 부가 정보
		System.out.println("총 페이지: "+ page.getTotalPages());
		System.out.println("현재페이지 번호: "+ page.getNumber());
		System.out.println("페이지당 데이터 개수: "+ page.getSize());
		System.out.println("다음 페이지 존재 여부: "+ page.hasNext());
		System.out.println("시작 페이지 여부: "+ page.isFirst());
		
	}
	
	@Test
	void 정렬조건추가하기() {
		// "no" 필드를 기준으로 역정렬
		// by는 static임, 컬럼명이 아니라 변수명을 써주면 댐~
		Sort sort = Sort.by("no").descending();
		
		Pageable pageable =  PageRequest.of(9, 5,sort);
		
		Page<Memo> page = repository.findAll(pageable);
		
		List<Memo> list = page.getContent();
		
		for (Memo memo  : list) {
			System.out.println(memo);
		}
		
	}
	

}
