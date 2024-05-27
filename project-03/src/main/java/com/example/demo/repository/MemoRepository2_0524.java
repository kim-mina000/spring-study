package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

// 쿼리 메소드를 사용해서 함수 만들기
@Transactional // 삭제할때 커밋을 자동으로 해주는 어노테이션
public interface MemoRepository2_0524 extends JpaRepository<Memo, Integer> {
	
	// 메모의 번호가 10에서 20 사이인 데이터 검색
	// select * from tb1_memo where no between ? and ? // ?는 파라미터
	List<Memo> findByNoBetween(int from, int to);
	
	// 메모의 번호가 10보다 작은 데이터 검색
	// select * from tb1_momo where no < ? 
	List <Memo> findByNoLessThan(int mno);

	// 메모의 번호를 기준으로 역정렬
	// select * from tbl_memo order by no desc
	List <Memo> findAllByOrderByNoDesc();
	
	// 메모의 번호가 3보다 작은 데이터 삭제
	// delect from tbl_memo where no < ?
	void deleteMemoByNoLessThan(int mno);
	

}
