package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest {
	
	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void 데이터일괄등록() {
		List<Gift> list = new ArrayList<>();
		
		// 선물번호는 자동으로 생략되므로 no는 생략 
		Gift gift1 = Gift.builder().name("참치세트").type("식품").price(10000).build();
		Gift gift2 = Gift.builder().name("햄세트").type("식품").price(20000).build();
		Gift gift3 = Gift.builder().name("샴푸세트").type("생활용품").price(30000).build();
		Gift gift4 = Gift.builder().name("세차용품").type("생활용품").price(40000).build();
		Gift gift5 = Gift.builder().name("주방용품").type("생활용품").price(50000).build();
		Gift gift6 = Gift.builder().name("노트북").type("가전제품").price(60000).build();
		Gift gift7 = Gift.builder().name("벽걸이TV").type("가전제품").price(70000).build();
		
		list.add(gift1);
		list.add(gift2);
		list.add(gift3);
		list.add(gift4);
		list.add(gift5);
		list.add(gift6);
		list.add(gift7);
		
		giftRepository.saveAll(list);
	}
	
	// 가격이 50000원이상인 선물
	@Test
	public void 가격오만언이상() {
		List<Gift> list = giftRepository.search1(50000);
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 세트로끝나는선물() {
		List<Gift> list = giftRepository.search2("세트");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 사만원이하생활용품() {
		List<Gift> list = giftRepository.search3("생활용품", 40000);
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
}
