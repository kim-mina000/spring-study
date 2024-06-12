package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.entity.TodoListEntity;

public interface TodoListService {
	// 추상메소드
	// 게시물 목록조회
	List<TodoListDTO> getList();
	
	// 공통기능
	default TodoListEntity dtoToEntity(TodoListDTO dto) {
			
		TodoListEntity entity = TodoListEntity.builder()
												.no(dto.getNo())
												.content(dto.getContent())
												.category(dto.getCategory())
												.done(dto.getDone())
												.build();
			return entity;
		}
	
	default TodoListDTO entityToDTO (TodoListEntity entity) {
		
		TodoListDTO dto = TodoListDTO.builder()
											.no(entity.getNo())
											.content(entity.getContent())
											.category(entity.getCategory())
											.done(entity.isDone())
											.regDate(entity.getRegDate())
											.build();
		return dto;
	}
}
