package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 붙여줘야 시간 생성!
@SpringBootApplication
public class Project12Application {

	public static void main(String[] args) {
		SpringApplication.run(Project12Application.class, args);
	}

}
