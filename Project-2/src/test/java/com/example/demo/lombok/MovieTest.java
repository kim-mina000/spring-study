package com.example.demo.lombok;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieTest {

	@Test
	void 영화테스트() {
		Movie movie1 = new Movie();
		 movie1.setDirector("Mark Dindal");
		 movie1.setTitle("The Garfield Movie");
		 movie1.setOpenDate(LocalDate.of(2024, 05, 15));
		System.out.println(movie1.getTitle()+" "+movie1.getDirector()+" "+
												movie1.getOpenDate());
		 
		 Movie movie2 = new Movie("Furiosa: A Mad Max Saga", "George Miller", LocalDate.of(2024,05,22));
		 System.out.println(movie2.toString());
		 
		 Movie movie3 = Movie.builder().title("Exhuma").director("Jang Jae-hyun").openDate( LocalDate.of(2024,02,22)).build();
		 System.out.println(movie3.toString());
	}
}
