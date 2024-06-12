package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

// Impl : 구현체 라는뜻
// @Service 어노테이션을 붙여주는 이유
// @Service 어노테이션의 유무에 따라 어떤 클래스를 사용할지 정해짐 -> 빈 관리에 유용
// @Componet - @Autowired 어노테이션과 유사
// @Service 어노테이션은 중복해서 사용할수 없음 부모 인터페이스를 상속 받았다면 하나의 클래스만이 @Service 어노테이션을 붙일 수 있음!
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardRepository repository;

	@Override
	public int register(BoardDTO dto) {
		// C -(dto)> S -(entity)> R
		// 컨트롤러에서 데이터를 받음 그러나 repository에는 entity만 저장할수 있음
		// 그래서 dto-> entity로 변환해준뒤 저장
		
		Board entity = dtoToEntity(dto);
		
		repository.save(entity);
		
		int newNo = entity.getNo();
		
		return newNo;
	}


	@Override
	public List<BoardDTO> getList() {
		// 게시물 목록 조회
		List<Board> entityList = repository.findAll();
		
		// Entity 리스트 -> DTO 리스트 변환
		List<BoardDTO> dtoList = new ArrayList<>();
		
//		for(Board board:entityList) {
//			dtoList.add(entityToDTO(board));
//		}
		
		dtoList = entityList.stream()
								.map(entity -> entityToDTO(entity))
								.collect(Collectors.toList());

		return dtoList; // DTO 리스트 변환
	}


	@Override
	public BoardDTO read(int no) {
		Optional<Board> result = repository.findById(no);
		
		if(result.isPresent()) {
			Board board = result.get();
			BoardDTO boardDTO = entityToDTO(board); // entity -> dto
			return boardDTO;
			
		} else {
			return null;
		}
	}


	@Override
	public void modify(BoardDTO dto) {
		Optional<Board> result = repository.findById(dto.getNo());
		
		if (result.isPresent()) {
			// 제목과 내용만 변경
			Board entity = result.get();
			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());
//			entity.setWriter(dto.getWriter());
			// 게시물 교체하기
			repository.save(entity);
		}
		
	}
	
}
