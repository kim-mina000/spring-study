package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

	@Test
	void 북테스트() {
		Book book1 = new Book();
		book1.setPageNum(600);
		book1.setPrice(15120);
		book1.setPublisher("현대문학");
		book1.setTitle("레베카");
		
		System.out.println(book1.getTitle()+ book1.getPageNum() + book1.getPublisher() + book1.getPrice());
		
		Book book2 = new Book("우리가 빛의 속도로 갈 수 없다면", 111000, "허블", 330);
		System.out.println(book2.toString());
		
		Book book3 = Book.builder().title("멋진 신세계").publisher("문예출판사").pageNum(416).price(11700).build();
		System.out.println(book3.toString());
	}
}
