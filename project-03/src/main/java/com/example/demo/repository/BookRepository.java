package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	// 제목이 '자바프로그래밍입문'인 책을 검색
	@Query(value = "select * from Book where title = \"자바프로그래밍입문_개정판\"", nativeQuery = true)
	List<Book> search();
	
	@Query("select b from Book b where b.title = :title")
	List<Book> search2(@Param("title") String title);
	
	
	// 	가격이 3만원 이상이고 	출판사 남가람북스인책을 검색
	@Query("select b from Book b where b.price >= :inputPrice and b.publisher=:inputTitle")
	List<Book> search3(@Param("inputPrice") int inputPrice,@Param("inputTitle") String inputTitle );
	
	// 출판사가 한빛출판사또는 이지 퍼블리싱인 책을 검색
	@Query("select b from Book b where b.publisher = :inputPublisher1 or b.publisher=:inputPublisher2")
	List<Book> search4(@Param("inputPublisher1") String inputPublisher1,@Param("inputPublisher2") String inputPublisher2);
}
