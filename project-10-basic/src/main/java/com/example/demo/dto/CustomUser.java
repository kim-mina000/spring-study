package com.example.demo.dto;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User{

//	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//		// TODO Auto-generated constructor stub
//	}

	// DTO와 USER 모두 사용자 정보를 담는 객체인데 사용 용도가 조금 다름 (ex: DTO와 Entity의 차이)
	public CustomUser(MemberDTO dto) {
		//MemberDTO -> USER
		// 사용자 아이디, 패스워드, 권한을 꺼내서 User객체 생성
		super(dto.getId(), dto.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));
	}

}
