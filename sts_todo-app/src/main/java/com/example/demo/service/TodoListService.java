package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.TodoList;

public interface TodoListService {
	// 추상메소드
	// 게시물 목록조회
	List<TodoListDTO> getList();
	
	// 특정 아이디가 쓴 목록만 조회
//	List<TodoListDTO> getYourTodo(Member member);
	
	// todo 저장
	void saveTodo(TodoListDTO todoList);
	
	// 공통기능
	default TodoList dtoToEntity(TodoListDTO dto) {
		Member memer = Member.builder().name(dto.getName()).build();
		
		TodoList entity = TodoList.builder()
												.no(dto.getNo())
												.name(memer)
												.content(dto.getContent())
												.category(dto.getCategory())
												.build();
			return entity;
		}
	
	default TodoListDTO entityToDTO (TodoList entity) {
		
		TodoListDTO dto = TodoListDTO.builder()
											.no(entity.getNo())
											.name(entity.getName().getName())
											.content(entity.getContent())
											.category(entity.getCategory())
											.done(entity.isDone())
											.regDate(entity.getRegDate())
											.build();
		return dto;
	}
}
