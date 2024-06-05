package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.RoomReservation;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Integer> {

	// 가장 마지막 예약번호 검색
	@Query(value="SELECT reservation_no FROM tbl_room_reservation ORDER BY reservation_no DESC LIMIT 1", nativeQuery = true)
	Integer getLastNumber();
	
}
