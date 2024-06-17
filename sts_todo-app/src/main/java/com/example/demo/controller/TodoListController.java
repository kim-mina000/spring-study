package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import com.example.demo.service.TodoListService;

@Controller
@RequestMapping("/todoList")
public class TodoListController {
	
	@Autowired
	TodoListService service;
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("")
	public String index() {
		return "/layout/index";
	}
	
	@PostMapping("")
	public String getName(Member member,RedirectAttributes redirectAttributes) {
		memberService.saveMember(member);
		redirectAttributes.addFlashAttribute("name",member.getName());
		return "redirect:/todoList/main";
	}

	@GetMapping("/main")
	public void main(Member member, Model model) {
		List<TodoListDTO> list = service.getList();	
		model.addAttribute("list",list);
	}
	
	@PostMapping("/main")
	public String main(TodoListDTO dto) {
		service.saveTodo(dto);
		return "./todoList/main";
	}
}
