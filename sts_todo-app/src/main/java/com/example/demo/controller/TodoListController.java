package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.service.TodoListService;

@Controller
@RequestMapping("/todoList")
public class TodoListController {
	
	@Autowired
	TodoListService service;

	@GetMapping("/main")
	public void main(Model model) {
		List<TodoListDTO> list = service.getList();
		model.addAttribute("list",list);
	}
}
