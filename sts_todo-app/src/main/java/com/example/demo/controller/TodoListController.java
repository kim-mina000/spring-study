package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.TodoListDTO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import com.example.demo.service.TodoListService;

import jakarta.servlet.http.HttpSession;

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
	public String getName(Member member,
//			RedirectAttributes redirectAttributes,
			HttpSession session) {
		memberService.saveMember(member);
		session.setAttribute("name", member.getName());
//		redirectAttributes.addFlashAttribute("name",member.getName());
		return "redirect:/todoList/main";	
	}

	@GetMapping("/main")
	public void main(
			Model model,
			HttpSession session
			) {
		String name = (String) session.getAttribute("name");
		
		Member member = Member.builder().name(name).build();
		List<TodoListDTO> list = service.getYourTodo(member);	
		

		model.addAttribute("list",list);
		model.addAttribute("name",name);
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println(now);
		model.addAttribute("now",now);
		
	}
	
	// 입력받기
	@PostMapping("/main")
	public String main(TodoListDTO dto, HttpSession session) {
//		[HttpSession]
//		https://muengx2.tistory.com/55 
		service.saveTodo(dto);
		String name = (String) session.getAttribute("name");
		return "redirect:/todoList/main";	
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("no") int no) {
		System.out.println("delete");
		System.out.println(no);
		service.delete(no);
		return "redirect:/todoList/main";
	}

	
	@PostMapping("/edit")
	@ResponseBody
	public String edit(TodoListDTO dto) {
		System.out.println("edit");
		service.edit(dto);
		return "redirect:/todoList/main";
	}
}
