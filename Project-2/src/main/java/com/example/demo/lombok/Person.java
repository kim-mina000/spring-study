package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data // Getter Setter ToString 한번에 사용하는 이노테이션

@Getter
@Setter
@ToString // 삭제하면 toString 했을때 주소값이 나옴
@NoArgsConstructor // 생성자
@AllArgsConstructor // 생성자
@Builder // 생성자
public class Person {
	
	String name;
	int age;
	
	
	

}
