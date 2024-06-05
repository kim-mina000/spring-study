package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.RoomReservation;

@SpringBootTest
public class RoomReservationTest {

	@Autowired
	 RoomReservationRepository roomReservationRepository;
	
	@Test
	public void 데이터추가() {
//		LocalDate localDate1 = LocalDate.of(2024, 6, 1);
//		LocalDate localDate2 = LocalDate.of(2024, 6, 2);
//		RoomReservation reservation1 = new RoomReservation(1, 201, "둘리",localDate1);
//		RoomReservation reservation2 = new RoomReservation(2, 201, "둘리",localDate2);
//		RoomReservation reservation3 = new RoomReservation(3, 202, "또치",localDate2);
		RoomReservation reservation1 = new RoomReservation(1, 201, "둘리","2024-06-01");
		RoomReservation reservation2 = new RoomReservation(2, 201, "둘리","2024-06-02");
		RoomReservation reservation3 = new RoomReservation(3, 202, "또치","2024-06-02");
		
		roomReservationRepository.save(reservation1);
		roomReservationRepository.save(reservation2);
		roomReservationRepository.save(reservation3);
	}
	
	@Test
	public void 데이터추가확인() {
//		LocalDate localDate = LocalDate.now();
		RoomReservation reservation = new RoomReservation(0, 203, "미나","2024-06-05");
		roomReservationRepository.save(reservation);
	}
	
	@Test
	public void 데이터삭제() {
		roomReservationRepository.deleteById(4);
	}
	
	@Test
	public void 가장마지막룸넘버() {
		System.out.println(roomReservationRepository.getLastNumber());
	}

	
}

