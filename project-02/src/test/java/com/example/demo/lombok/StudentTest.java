package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
	@Test
	void 학생테스트() {
		Student student1 = new Student();
		student1.setAge(3);
		student1.setName("시리");
		student1.setId(1001);
		
		System.out.println(student1.getName()+", "+student1.getAge()+"살, "+student1.getId());
		
		Student student2 = new Student(1002, "서원석", 30);
		System.out.println( student2.toString());
		
		Student student3 = Student.builder().Id(1003).age(27).name("미냐").build();
		System.out.println(student3.toString());
		
		
	}
}
