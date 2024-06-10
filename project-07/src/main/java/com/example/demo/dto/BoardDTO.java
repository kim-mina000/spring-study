package com.example.demo.dto;

import java.time.LocalDateTime;

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
// DTO는 view 단에 전달
// Entity는 Repository(DB)에 전달
// Service data가공과 비즈니스 로직을 처리하는데 사용
// 투체제로 만드는이유? 인터페이스를 쓰는 이유와 동일
// 수정이나 교체가 있었을때 코드변경없이 쉽게 교체하기위해
public class BoardDTO {
	int no;
	String title;
	String content;
	String writer;
	LocalDateTime regDate;
	LocalDateTime modDate;
	
}
