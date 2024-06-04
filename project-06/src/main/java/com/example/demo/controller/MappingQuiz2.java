package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.CarDTO;
import com.example.demo.DTO.StudentDTO;

@Controller
@RequestMapping("/param")
public class MappingQuiz2 {
	
	// 2. 파라미터 형태
	// 간단 -> 파라미터를 주소에 담기 :: @RequestParam 또는 @PathVariable
	// 복잡 -> 파라미터를 메세지 바디에 담기 :: @RequestParam @PathVariable 보다는 @RequestBody

	@ResponseBody
	@GetMapping("/q1")
	public String q1(@RequestParam(name = "str") String str) {
		System.out.println("String타입 파라미터 수집: "+str);
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q2")
	public String q2(@RequestParam(name = "f") float f, @RequestParam(name="b")boolean b) {
		System.out.println("float타입 파라미터 수집: "+f+", boolean타입 파라미터 수집: "+b);
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public String q3(@RequestParam(name = "arr") char[] arr) {
		System.out.println("Char형 배열 수집: "+arr);
		for(char c : arr) {
			System.out.println(c);
		}
		System.out.println("배열의 개수: "+arr.length);
		return "ok";
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/q4") public String q4(@ModelAttribute StudentDTO dto) {
	 * System.out.println("객체 수집: "+dto); return "ok"; }
	 */
	
	@ResponseBody
	@PostMapping("/q4")
	public String q4(@RequestBody StudentDTO dto) {
		System.out.println("객체 수집: "+dto);
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q5")
	public String q5(@RequestBody StudentDTO[] dto) {
		System.out.println("객체타입 리스트 수집: "+Arrays.toString(dto));
		for(StudentDTO student: dto) {
			System.out.println(student);
		}
		System.out.println("리스트의 개수: " +dto.length );
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q6")
	public String q6(@RequestBody ArrayList<CarDTO> dto) {
		System.out.println("객체타입 리스트 수집: "+dto);
		for(CarDTO car: dto) {
			System.out.println(car);
		}
		System.out.println("리스트의 마지막 요소: " +dto.get(dto.size()-1));
		return "ok";
	}
	
}
