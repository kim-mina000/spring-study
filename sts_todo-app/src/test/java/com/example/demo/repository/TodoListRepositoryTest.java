package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.TodoListEntity;

@SpringBootTest
public class TodoListRepositoryTest {

	@Autowired
	TodoListRepository  repository;
	
	@Test
	public void 레파짓토리생성() {
		// done 값이 자동으로 false 들어가게 해주면 좋겠음
		// regDate 안들어가짐
		TodoListEntity entity = TodoListEntity.builder()
																						.content("호에엥 ㅠㅠ ,,,")
																						.category("기타")
																						.done(false)
																						.build();
		repository.save(entity);
	}
	
	
}
