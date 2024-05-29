package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.PersonDTO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@GetMapping("/q1")
	public String quiz1(Model model) {
		model.addAttribute("name","둘리");
		model.addAttribute("age","20");
		model.addAttribute("address","인천 구월동");
		return "/quiz/q1";
	}
	
	@GetMapping("/q2")
	public void quiz2(Model model) {
		model.addAttribute("title", "스프링부트웹프로젝트");
		model.addAttribute("author", "구멍가게 코딩단");
		model.addAttribute("date", LocalDate.of(2022, 12, 5));	
	}
	
	@GetMapping("/q3")
	public void quiz3(Model model) {
		PersonDTO personDTO = new PersonDTO("둘리", 20, "인천 구월동");
		
		model.addAttribute("personDTO", personDTO);
	}
	
	@GetMapping("/q4")
	public void quiz4(Model model) {
		model.addAttribute("bookDTO", new BookDTO("스프링부트웹프로젝트","구멍가게코딩단",LocalDate.of(2022, 12, 25)));
	}

}
