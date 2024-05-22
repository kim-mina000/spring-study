package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

// 쿼리 메소드 사용하기
@Transactional
public interface MemoRepository2 extends JpaRepository<Memo, Integer>{
	
	// 메모의 번호가 2에서 3 사이인 데이터 검색
//	select * from tbl_memo where no between 2 and 3
	List<Memo> findByNoBetween(int from, int to);
}
