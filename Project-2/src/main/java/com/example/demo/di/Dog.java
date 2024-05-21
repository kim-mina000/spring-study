package com.example.demo.di;

import org.springframework.stereotype.Component;

// static과 비슷한 역할 각자에게 고유한 값을 줄수는 없으나 똑같은 기능을 여러번 가져다 쓸때에는 유용함
// 공유해서 사용한다는 느낌과 비슷! 메모리를 절약,,, 객체를 각각 생성할지, Component로 사용할지는 선택해야함
@Component
public class Dog {
	
	void sound() {
		System.out.println("(U ･ꎴ･) < 왕 왕 )");
	}
}
