package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

public interface MemberService {

	// 멤버 저장
	void saveMember(Member member);
	
	// 멤버 조회 (단건)
	MemberDTO read(Member member);
	

	// 공통기능
	default Member dtoToEntity(MemberDTO dto) {
		Member entity = Member.builder()
												.name(dto.getName())
												.build();
			return entity;
		}
	
	default MemberDTO entityToDTO (Member entity) {
		MemberDTO dto = MemberDTO.builder()
											.name(entity.getName())
											.build();
		return dto;
	}
	
}
