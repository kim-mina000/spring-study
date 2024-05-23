package com.example.demo.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.MemoRepository;
import com.example.demo.entity.Memo;

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
	

}
