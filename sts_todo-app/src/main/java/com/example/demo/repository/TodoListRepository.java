package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TodoListEntity;

@Repository
public interface TodoListRepository extends  JpaRepository<TodoListEntity, Integer>{

}