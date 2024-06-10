package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;

// Impl : 구현체 라는뜻
// @Service 어노테이션을 붙여주는 이유
// @Service 어노테이션의 유무에 따라 어떤 클래스를 사용할지 정해짐 -> 빈 관리에 유용
// @Componet - @Autowired 어노테이션과 유사
// @Service 어노테이션은 중복해서 사용할수 없음 부모 인터페이스를 상속 받았다면 하나의 클래스만이 @Service 어노테이션을 붙일 수 있음!
@Service
public class BoardServiceImpl implements BoardService{

	@Override
	public int register(BoardDTO dto) {
		
		return 0;
	}
	
}
