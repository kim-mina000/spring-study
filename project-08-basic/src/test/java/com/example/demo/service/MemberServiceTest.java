package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	MemberService service;

	@Test
	public void 회원목록조회() {
		Page<MemberDTO> dto = service.getList(0);
		
//		List<MemberDTO> list = dto.getContent();
//		System.out.println(list); // 이렇게해도됨!
		
		for(MemberDTO member: dto) {
			System.out.println(member);
		}
	}
}
