package com.example.demo.service;

import java.time.LocalDateTime;

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
	
	@Test
	public void 회원아이디등록1() {
		MemberDTO dto = MemberDTO.builder()
				.id("냐냐냐냥")
				.password("1234")
				.name("하핫")
				.modDate(LocalDateTime.now())
				.regDate(LocalDateTime.now())
				.build();
		
		boolean isSuccess = service.register(dto);
		if(isSuccess) {
			System.out.println("회원이 등록되었습니다");
		} else {
			System.out.println("중복된 아이디 입니다");
		}
		
		
		
	}
	@Test
	public void 회원아이디등록2() {
		MemberDTO dto = MemberDTO.builder()
				.id("user22")
				.password("1234")
				.name("하핫")
				.modDate(LocalDateTime.now())
				.regDate(LocalDateTime.now())
				.build();
		
		service.register(dto);
		
	}
	
}
