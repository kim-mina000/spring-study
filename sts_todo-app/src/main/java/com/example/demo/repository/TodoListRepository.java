package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TodoList;

@Repository
public interface TodoListRepository extends  JpaRepository<TodoList, Integer>{

//	@Query(value = "SELECT * FROM tbl_todo_list todo WHERE todo.name_name = :member", nativeQuery = true)
//	List<TodoList> get(@Param("name") Member member);
}
