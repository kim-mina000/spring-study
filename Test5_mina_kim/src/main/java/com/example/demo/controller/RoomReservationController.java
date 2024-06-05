package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.RoomReservation;
import com.example.demo.repository.RoomReservationRepository;
import com.example.demo.service.GuestService;

@Controller
@RequestMapping("/reservation")
public class RoomReservationController {
	
	@Autowired
	GuestService guestService;
	
	@Autowired
	RoomReservationRepository repository;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("guest", guestService.getAllGuest());
		return "reservation/list";
	}
	
	@GetMapping("/save")
	public String save() {
		return "reservation/save";
	}
	
	@ResponseBody
	@PostMapping("/save")
	public String post(@ModelAttribute  RoomReservation newGuest) {
			System.out.println(newGuest);
			repository.save(newGuest);
		return (repository.getLastNumber()+1) + "번 새로운 예약이 추가되었습니다!";
	}
	
//	@PostMapping("/save")
//	public String post(@ModelAttribute  RoomReservation newGuest) {
//			System.out.println(newGuest);
//			repository.save(newGuest);
//		return (repository.getLastNumber()+1) + "번 새로운 예약이 추가되었습니다!";
//	}
	
//	@PostMapping("/save")
//	public ResponseEntity<String> ex6(@ModelAttribute  RoomReservation newGuest) {
//			System.out.println(newGuest);
//			repository.save(newGuest);
//		return new ResponseEntity<>( (repository.getLastNumber()+1) + "번 새로운 예약이 추가되었습니다!", HttpStatus.OK);
//	}
	
}
