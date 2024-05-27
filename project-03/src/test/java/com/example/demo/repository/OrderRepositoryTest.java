package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 데이터삽입() {
		List<Order> list = new ArrayList<>();
		list.add(new Order(0,"둘리","인천 구월동",LocalDate.of(2023, 7, 1)));
		list.add(new Order(0,"또치","인천 연수동",LocalDate.of(2023, 7, 2)));
		list.add(new Order(0,"도우너","부산 동래동",LocalDate.of(2023, 7, 3)));
		orderRepository.saveAll(list);
	}
	
	@Test
	public void 데이터삭제() {
		orderRepository.deleteAll();
	}
	
	@Test
	public void 주소지가인천인주문검색() {
		List<Order> list = orderRepository.search1("인천");
		
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 주문일이7월3일인주문검색 () {
		List<Order> list = orderRepository.search2(LocalDate.of(2023, 7, 3));
		
		for(Order order : list) {
			System.out.println(order);
		}
	}
}
