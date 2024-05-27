package com.example.demo.entity;

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
@Table(name = "tbl_book")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bookNo;
	
	@Column(length = 30, nullable = false)
	String title;
	
	@Column(length=100, nullable=true)
	String publisher;
	
	@Column(nullable=true)
	int price;

	
}
