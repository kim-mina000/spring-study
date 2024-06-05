package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RoomReservation;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Integer> {

}
