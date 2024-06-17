package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository repository;
	
	@Override
	public Page<MemberDTO> getList(int pageNumber) {
		int pageNum = (pageNumber==0)? 0 : pageNumber-1;
		
		Sort sort = Sort.by("regDate").descending();
		
		Pageable  pageable = PageRequest.of(pageNum, 10,sort);
		
		Page<Member> entityPage = repository.findAll(pageable);
		
		Page<MemberDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));
		
		return dtoPage;
	}

	@Override
	public MemberDTO read(String userId) {
		Optional<Member> result = repository.findById(userId);
		
		if(result.isPresent()) {
			Member member = result.get();
			MemberDTO dto = entityToDto(member);
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public boolean register(MemberDTO dto) {
		String id = dto.getId();
		MemberDTO getDTO = read(id);
		
		if(getDTO != null) {
			System.out.println("사용중인 아이디입니다.");
			return false;
		} else {
			Member entity = dtoToEntity(dto);
			repository.save(entity);
			System.out.println("등록되었습니다");
			return true;
		}
	}

}
