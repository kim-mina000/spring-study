package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TodoList;

@Repository
public interface TodoListRepository extends  JpaRepository<TodoList, Integer>{

	@Query(value = "SELECT * FROM tbl_todo_list todo WHERE todo.name_name = :name", nativeQuery = true)
	List<TodoList> get(@Param("name") String name);
}
