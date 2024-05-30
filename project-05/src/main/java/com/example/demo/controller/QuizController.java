package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.SampleDTO;

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
	
	@GetMapping("/q5")
	public void quiz5(Model model) {
		int[] intArr = {1,2,3,4,5,6,7,8,9,10};
		model.addAttribute("intArr" ,intArr);
	}
	
	@GetMapping("/q6")
	public void quiz6(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		list.add(new PersonDTO("둘리", 20, "인천 구월동"));
		list.add(new PersonDTO("또치", 30, "서울 신림동"));
		list.add(new PersonDTO("도우너", 40, "부산 문래동"));
		
		model.addAttribute("personDTOList",list);
	}
	
	@GetMapping("/q7")
	public void quiz7(Model model) {
		List<SampleDTO> list = new ArrayList<>();
		for(int i = 1; i <= 20 ; i++) {
			list.add(new SampleDTO(i, i+"번", LocalDate.now()));
		}
		model.addAttribute("sampleDTOList",list);
	}

	@GetMapping({"/q8","/q9"})
	public void quiz8(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		list.add(new PersonDTO("박하나",25,"인천 구월동"));
		list.add(new PersonDTO("홍재범",17,"서울 신림동"));
		list.add(new PersonDTO("문유리",31,"부산 문래동"));
		list.add(new PersonDTO("김재민",8,"인천 연수동"));
		list.add(new PersonDTO("장유라",33,"부산 문래동"));
		
		model.addAttribute("personDTOList",list);
	}
}
