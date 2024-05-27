package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

import jakarta.transaction.Transactional;

@Transactional
public interface GiftRepository extends JpaRepository<Gift, Integer>{

	// 가격이 50000원이상인선물 검색
	@Query(value="select * from tbl_gift where price >= :inputPrice", nativeQuery = true )
	List<Gift> search1 (@Param("inputPrice") int inputPrice);
	
	//이름이 세트로끝나는 선물을 검색
	@Query("select g from Gift g where g.name like %:set")
	List<Gift> search2(@Param("set") String set);
	
	//가격은 4만원이하품목은 생활용품
	@Query("select g from Gift g where g.type = :inputType and g.price <= :inputPrice")
	List<Gift> search3(@Param("inputType") String inputType,@Param("inputPrice") int inputPrice);
}
