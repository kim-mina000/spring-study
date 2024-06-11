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

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_todoList")
public class TodoListEntity  extends BaseTodoListEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int no;
	
	@Column (length = 50, nullable = false)
	String content;
	
	@Column
	String category;
	
	@Column (nullable=false)
	Boolean done;
}
