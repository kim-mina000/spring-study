package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

@Transactional
public interface MemoRepository3  extends JpaRepository<Memo, Integer>{
	
	// 단건조회, 목록조회, 수정, 삭제, 추가, 페이징 -> Jpa에서 기본으로 제공하는 항목
	
	// 조건 검색 기능 추가하고 싶을때! 쿼리메소드나 어노테이션 추가하면됨
	
	// 메모의 번호가 3보다 작은 데이터 검색
	// select * from tbl_memo(엔티티) where no(변수) < ?
	// jpql 문법으로 변경 ->
	@Query("select m from Memo m where m.no < :mno") // 여기서 Memo 다음의 m은 별칭임! 별칭을 * 대신에 사용해주면됨
	List<Memo> get1(@Param("mno") int mno); // ?파라미터를 매개변수로 선언 
	
	// 메모의 번호가 2에서 3사이인 데이터 검색
	// select * from tbl_memo where no between ? and ?
//	@Query("select m from Memo m where m.no > :from && m.no< :to")
	@Query("select m from Memo m where m.no between :from and :to")
	List<Memo> get3(@Param("from") int from, @Param("to") int to); // 여기서 "from" "to"는 SQL에서 사용할 파라미터 이름이다
	
	// 메모의 번호를 기준으로 역정렬
	// select * from tbl_memo order by no desc
	@Query("select m from Memo m ORDER BY m.no DESC")
	List<Memo> get4();
	
	// SQL문법 그대로 사용!
//	@Query(value="select * from tbl_memo order by no desc", nativeQuery = true)
//	List<Memo> get4();
	
}
