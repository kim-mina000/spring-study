package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.RoomReservation;

@SpringBootTest
public class RoomReservationTest {

	@Autowired
	RoomReservationRepository repository;

	@Test
	public void 데이터등록() {
		
		LocalDate date = LocalDate.of(2024, 6, 1);
		RoomReservation reservation = RoomReservation.builder()
													.roomNo(201).guestName("둘리").checkInDate(date)
													.build();
		repository.save(reservation);
		
		LocalDate date2 = LocalDate.of(2024, 6, 2);
		RoomReservation reservation2 = RoomReservation.builder()
													.roomNo(201).guestName("둘리").checkInDate(date2)
													.build();
		repository.save(reservation2);
		
		RoomReservation reservation3 = RoomReservation.builder()
													.roomNo(202).guestName("또치").checkInDate(date2)
													.build();
		repository.save(reservation3);

	}

	@Test
	public void 데이터단건조회() {
		
		Optional<RoomReservation> result = repository.findById(1); 
		
		if (result.isPresent()) {
			RoomReservation reservation = result.get();
			System.out.println(reservation);
		}
	}

	@Test
	public void 데이터전체조회() {

		List<RoomReservation> list = repository.findAll(); 
		
		for (RoomReservation reservation : list) {
			System.out.println(reservation);
		}
	}

	@Test
	public void 데이터수정() {

		Optional<RoomReservation> result = repository.findById(1); 
		RoomReservation reservation = result.get();
		
		LocalDate date = LocalDate.of(2024, 5, 1);
		reservation.setCheckInDate(date);

		repository.save(reservation);
	}

	@Test
	public void 데이터삭제() {
		repository.deleteById(1);
	}

	@Test
	public void 데이터전체삭제() {
		repository.deleteAll();
	}

}
