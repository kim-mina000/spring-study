package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.entity.Member;

@SpringBootTest
public class TodoListServiceTest {
	
	@Autowired
	TodoListService service;
	
	
	// 저장이 안됨 저장이 service 가문제인지 test가 문제인지 모르게슴
	@Test
	public void 투두가디비에저장되는지 () {
		TodoListDTO dto = TodoListDTO.builder()
																				.name("hi")
																				.category("기타")
																				.content("얏호집가자~")
																				.build();
		service.saveTodo(dto);
	}
	
	@Test
	public void 특정아이디로만조회() {
		List<TodoListDTO> list = service.getYourTodo(Member.builder().name("미나").build());
		for(TodoListDTO dto: list) {
			System.out.println(dto);
		}
	}
}
