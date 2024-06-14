package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.entity.Member;
import com.example.demo.entity.TodoList;

@EnableJpaAuditing
@SpringBootTest
public class TodoListRepositoryTest {

	@Autowired
	TodoListRepository  repository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 레파짓토리생성() {
		// done 값이 자동으로 false 들어가게 해주면 좋겠음
		// regDate 안들어가짐
		TodoList entity = TodoList.builder()
																						.content("우앵?")
																						.category("기타")
																						.name(Member.builder().name("미나").build())
																						.build();
		repository.save(entity);
	}
	
	@Test
	public void 멤머레파짓토리생성() {
		Member member = Member.builder().name("미나").build();
		memberRepository.save(member);
	}
	
	
}
