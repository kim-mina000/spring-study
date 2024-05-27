package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {

	MemberRepository memberRepository = new MemberRepository();
	
	@Test
	public void 테스트() {
		// 회원등록
		memberRepository.save(new Member(0,"user1","1234"));
		memberRepository.save(new Member(0,"user2","1234"));
		
		
		System.out.println("첫번째 회원 : "+memberRepository.findById(1));
		System.out.println("회원 목록 :");
		for(Member member : memberRepository.findAll()) {
			System.out.println(member);
		}

		memberRepository.clearStore();
		
		System.out.println("삭제 후 회원 목록 : ");
		for(Member member : memberRepository.findAll()) {
			System.out.println(member);
		}
	}
}
