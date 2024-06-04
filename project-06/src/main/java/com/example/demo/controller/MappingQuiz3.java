package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.CarDTO;
import com.example.demo.DTO.StudentDTO;

@Controller
@RequestMapping("/return")
public class MappingQuiz3 {

	@GetMapping("/q1")
	public void q1() {
//		return "return/q1";
	}
	
	@GetMapping("/q2")
	public String q2() {
		return "return/test";
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public StudentDTO q3() {
		StudentDTO studentDTO = new StudentDTO(1,"둘리",3);
		return studentDTO;
	}	
	
	@ResponseBody
	@GetMapping("/q4")
	public CarDTO q4() {
		CarDTO carDTO = new CarDTO("현대","코나","블랙");
		return carDTO;
	}
	
	@ResponseBody
	@GetMapping("/q5")
	public ArrayList<StudentDTO> q5() {
		ArrayList<StudentDTO> list = new ArrayList<>();
		list.add(new StudentDTO(1,"둘리",3));
		list.add(new StudentDTO(2,"또치",1));
		list.add(new StudentDTO(3,"도우너",2));
		return list;
	}
	
	@ResponseBody
	@GetMapping("/q6")
	public ResponseEntity<String> q6() {
		return new ResponseEntity<>("response fail..",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseBody
	@GetMapping("/q7")
	public ResponseEntity<CarDTO> q7() {
		CarDTO carDTO = new CarDTO("현대","코나","블랙");
		return new ResponseEntity<>(carDTO,HttpStatus.OK);
	}
}
