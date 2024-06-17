package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberRepository repository;
	
	@Override
	public void saveMember(Member member) {
		repository.save(member);
	}

	@Override
	public MemberDTO read(Member member) {
		Optional<Member> result = repository.findById(member.getName());
		
		if (result.isPresent()) {
			Member entity = result.get();
			MemberDTO dto = entityToDTO(entity);
			return dto;
		} else {
			return null;
		}
	}

}
