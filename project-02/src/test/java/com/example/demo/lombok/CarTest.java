package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTest {

	@Test
	void 자동차테스트() {
		Car car1 = new Car();
		car1.setColor("White");
		car1.setCompany("KIA");
		car1.setModel("Sorento");
		
		System.out.println(car1.getColor()+" "+ car1.getCompany()+" "+car1.getModel());
		
		Car  car2 = new Car("티볼리", "쌍용", "gray");
		System.out.println(car2.toString());
		
		Car car3 = Car.builder().color("Black").model("Genesis").company("Hyundai").build();
		System.out.println(car3.toString());
	}
}
