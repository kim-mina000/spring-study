package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	MemberService service;

	@Test
	public void 회원등록() {
		MemberDTO dto = MemberDTO.builder()
													.id("user")
													.password("1234")
													.role("ROLE_USER")
													.name("시리")
													.build();
		service.register(dto);
													
	}

	@Test
	public void 회원목록조회() {

	}

	@Test
	public void 회원단건조회() {

	}
	
}
