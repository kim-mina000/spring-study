package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoomReservation;
import com.example.demo.repository.RoomReservationRepository;

@Service
public class GuestService {
	@Autowired
	 RoomReservationRepository roomReservationRepository;
	
	public List<RoomReservation> getAllGuest(){
		return roomReservationRepository.findAll();
	}
}


