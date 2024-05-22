package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.MemoRepository;
import com.example.demo.entity.Memo;

// 메모리 리자피토리를 사용하여 메모 테이블의 데이터를 등록, 조회, 수정, 삭제한다
@SpringBootTest
public class MemoRepositoryTest1_1 {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void 리파지토리객체를가져왔는지확인() {
		System.out.println("memoRepository = " + memoRepository);
		// 주소가 출력됨
	}
	
	@Test
	public void 데이터등록() {
		Memo memo = new Memo(0,"새글입니다");
		//no는 auto_increment조건이므로 빈값 넣기
		memoRepository.save(memo);	 //1번이 존재하는지 확인하고 insert 실행
	}
	
	@Test
	public void 데이터일괄등록() {
		List<Memo> list = new ArrayList<>();
		Memo memo1 = new Memo(0,"새글입니다");
		Memo memo2 = new Memo(0,null); //text는 null조건이므로 빈값 넣기
		list.add(memo1);
		list.add(memo2);
		memoRepository.saveAll(list);
	}
	
	@Test
	public void 데이터단건조회() {	
		Optional<Memo> result = memoRepository.findById(1);
		// 조회 결과를 optional로 반환, 결과가 존재하는지 확인하는 형태
		if(result.isPresent()) { // 결과값이 있는지 확인
			Memo memo = result.get(); // 값 꺼내기
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Memo> list = memoRepository.findAll();
		// 조회 결과를 리스트로 반환
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터수정() {
		Memo memo = new Memo(1,"글수정됐수깡?");
		// 1번 메모 객체 생성
		memoRepository.save(memo);
		// 1번이 존재하는지 확인하고 update 실행
	}
	
	@Test
	public void 데이터삭제() {
		memoRepository.deleteById(1);
		// 1번이 존재하는지 확인하고 delete 실행
		// 1번이 없으면 DataAccessException 에러가 발생함
	}
	
	@Test
	public void 데이터전체삭제() {
		memoRepository.deleteAll();
		// 테이블을 조회하고 모든 데이터를 삭제함
	}
	
}
