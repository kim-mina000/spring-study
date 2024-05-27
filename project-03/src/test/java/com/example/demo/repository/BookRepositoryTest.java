package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepository;
	
	
	@Test
	public void 데이터삽입() {
		List<Book> list = new ArrayList<>();
		Book book1 = new Book(0,"자바프로그래밍입문","한빛출판사",20000); // 책번호는 자동으로 생략되므로 no는 생략 
		Book book2 = new Book(0,"스프링부트프로젝트","남가람북스",25000);
		Book book3 = new Book(0,"실무로 끝내는 PHP","남가람북스",40000);
		Book book4 = new Book(0,"알고리즘코딩테스트","이지스퍼블리싱",35000);
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		bookRepository.saveAll(list);
	}
	
	@Test
	public void 데이터수정() {
		Optional<Book> result = bookRepository.findById(1);
		Book book = result.get();
		book.setTitle("자바프로그래밍입문");
		bookRepository.save(book);	
	}

	@Test
	public void 제목이자바프로그래밍입문인책을검색() {
//		List<Book> list = bookRepository.search();
		List<Book> list =bookRepository.search2("자바프로그래밍입문");
		
		for(Book book : list){
			System.out.println(book);
		}
	}
	
	@Test
	public void 삼만원이상남가람북스() {
		List<Book> list =bookRepository.search3(30000, "남가람북스");
		for(Book book : list){
			System.out.println(book);
		}
	}
	
	@Test
	public void 한빛출판사또는이지퍼블리싱() {
		List<Book> list =bookRepository.search4("한빛출판사", "이지스퍼블리싱");
		for(Book book : list){
			System.out.println(book);
		}
	}
	

	

}
