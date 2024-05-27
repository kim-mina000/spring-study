package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest // 컨테이너 환경
public class MemoRepositoryTest2 {
	
	@Autowired
	MemoRepository2_0524 memoRepository; // 빈 생성
	
	@Test // 단위 Test
	public void 번호가10와20사이의데이터검색 () {
		List<Memo> list = memoRepository.findByNoBetween(10, 20);
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 텍스트가null이아닌데이터검색() {
		List<Memo> list = memoRepository.findByNoLessThan(10);
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호를기준으로역정렬한데이터검색() {
		List<Memo> list = memoRepository.findAllByOrderByNoDesc();
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가5보다작은데이터삭제() {
		memoRepository.deleteMemoByNoLessThan(10);
		// commit(반영시켜주는) 명령이 없어서 에러가 남
		// 기본으로 제공하는 delete는 commit 명령이 포함되어있음
		// 레파짓토리에서 @Transactional 어노테이션을 추가해주면 됨
		// 조회의 경우 원본 데이터에 영향이 가지 않기 때문에 commit이 필요가 없지만 삭제의 경우 원본데이터에 영향이 가기 때문에 commit이 필요
	}
}
