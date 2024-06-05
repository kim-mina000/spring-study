package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.RoomReservation;
import com.example.demo.repository.RoomReservationRepository;

@Controller
@RequestMapping("/reservation")
public class RoomReservationController {
	
	@Autowired
	RoomReservationRepository repository;
	
	// GET localhost:8080/reservation/list
	@GetMapping("/list")
	public String list(Model model) {
		List<RoomReservation> list = repository.findAll(); 
        model.addAttribute("list", list);
		return "/reservation/list";
	}

	// GET localhost:8080/reservation/save
	@GetMapping("/save")
	public String saveForm() {
		return "/reservation/save";
	}

	@ResponseBody
	@PostMapping("/save")
	public String save(RoomReservation reservation) {
		System.out.println("RoomReservation="+reservation);
		repository.save(reservation);
		int reservationNo = reservation.getReservationNo();
		return reservationNo + "번 새로운 예약이 추가되었습니다!";
	}

}
