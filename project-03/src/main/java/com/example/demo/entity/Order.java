package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderNo;
	
	@Column(length=30, nullable=true)
	String customerName;
	
	@Column(length= 100, nullable=true)
	String shipAddress;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(nullable=true)
	LocalDate orderDate;
	
}
