package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.TodoList;
import com.example.demo.repository.TodoListRepository;

@Service
public class TodoListServiceImpl implements TodoListService{

	@Autowired
	TodoListRepository repository;
	

	// 게시물 목록 조회
	@Override
	public List<TodoListDTO> getList() {
			List<TodoList> entityList = repository.findAll();
			List<TodoListDTO> dtoList = entityList.stream()
																						.map(entity -> entityToDTO(entity))
																						.collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public void saveTodo(TodoListDTO dto) {
		TodoList entity = dtoToEntity(dto);
		repository.save(entity);
	}

	@Override
	public List<TodoListDTO> getYourTodo(Member member) {
		List<TodoList> entityList = repository.get(member.getName());
		List<TodoListDTO> dtoList = entityList.stream().map(entity -> entityToDTO(entity)).collect(Collectors.toList());	
		return dtoList;
	}

	@Override
	public void edit(TodoListDTO dto) {
		Optional<TodoList> result = repository.findById(dto.getNo());
		if(result.isPresent()) {
			TodoList entity = result.get();
			entity.setContent(dto.getContent());
			repository.save(entity);
		}
		
	}

	@Override
	public void delete(int no) {
		repository.deleteById(no);
	}
	
	
}
