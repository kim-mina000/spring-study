package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

	// 추상메소드 (게시물과 관련된 기능)
	
	// 게시물 등록 메소드
	int register(BoardDTO dto);
	
	// dto를 엔티티로 변환하는 메소드 (일반메소드)
	// view 단에서는 dto를 처리, DB에서는 엔티티로 로직을 처리하기 때문에 DTO를 엔티티로 변환해주어야한다
	// default 명령어를 붙여주면 추상메소드 뿐만아니라 일반메소드도 인터페이스 안에서 구현이 가능하다
	
	// 추상메소드의 특징 -> 선언부만 작성
	// 일반메소드의 특징 -> 선언부와 구현부 모두 작성
	
	// 추상메소드의 목적 -> 자식 클래스들이 각자 구현해서 사용하는 기능
	// 일반메소드의 목적 -> 자식 클래스들이 공통으로 사용하는 기능
	// dtoToEntity는 자식클래스들이 공통으로 사용하는 기능이기 때문에 일반 메소드로 선언
	default Board dtoToEntity(BoardDTO dto) {
		
		Board entity = Board.builder()
											.no(dto.getNo())
											.title(dto.getTitle())
											.content(dto.getContent())
											.writer(dto.getWriter())
											.build();
		return entity;
	}
	
	// 엔티티를 DTO로 변환하는 메소드 // 조회할때 사용
	// 매개변수 :엔티티, 리턴타입 DTO
	default BoardDTO entityToDTO (Board entity) {
		
		BoardDTO dto = BoardDTO.builder()
											.no(entity.getNo())
											.title(entity.getTitle())
											.content(entity.getContent())
											.writer(entity.getWriter())
											.regDate(entity.getRegDate())
											.modDate(entity.getModDate())
											.build();
		return dto;
	}
}
