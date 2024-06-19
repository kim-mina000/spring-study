package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.dto.TodoListDTO;
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
		TodoListDTO dto = TodoListDTO.builder()
																		.name("냐냐")
																		.content(">>>?")
																		.category("??")
																		.build();

	}
	
	@Test
	public void 데이터들어가나() {
		Member member = Member.builder().name("냐냐냐").build();
		TodoList entity = TodoList.builder()
															.content("집가기")
															.category("강아지")
															.name(member)
															.build();
		
		repository.save(entity);
															
	}
	
	@Test
	public void 멤머레파짓토리생성() {
		Member member = Member.builder().name("미나").build();
		memberRepository.save(member);
	}
	
	@Test
	void 특정아이디로만조회() {
		System.out.println(repository.get("미나"));
		
	}
	
	
}
