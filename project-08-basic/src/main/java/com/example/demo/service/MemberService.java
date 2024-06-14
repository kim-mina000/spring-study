package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

public interface MemberService {
	
	// 회원 목록 조회 메소드
	Page<MemberDTO> getList (int pageNumber);
	
	// dto를 엔티티로 변환하는 메소드
	default Member dtoToEntity(MemberDTO dto) {

		Member entity = Member.builder()
				.id(dto.getId())
				.password(dto.getPassword())
				.name(dto.getName())
				.build();
		
		return entity;
	}

	// 엔티티를 dto로 변환하는 메소드
	default MemberDTO entityToDto(Member entity) {

		MemberDTO dto = MemberDTO.builder()
				.id(entity.getId())
				.password(entity.getPassword())
				.name(entity.getName())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}
}
