package com.example.demo.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration // 스프링 설정 클래스
@EnableWebSecurity // 보안설정
public class SecurityConfig {

	// 사용자 정의 필터체인을 빈으로 등록하는 메소드
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// 게시물 관리는 관리자 또는 일반사용자만 접근가능
		// 회원 관리는 관리자만 접근 가능
		http.authorizeHttpRequests().requestMatchers("/register").permitAll() // 모든 사용자에게 허용
				// 앞부분은 url 뒷부분은 권한!
				.requestMatchers("/assets/*", "/css/*", "/js/*").permitAll().requestMatchers("/").authenticated() // 인증된
																													// 사용자면
																													// 허용
				.requestMatchers("/board/*").hasAnyRole("ADMIN", "USER") // hasRole( [role] ) 해당 권한이 있으면 허용
				.requestMatchers("/comment/*").hasAnyRole("ADMIN", "USER") // hasAnyRole( [role,role2]) 여러 권한들 중에서 하나라도
																			// 해당하는 권한이 있으면 허용
				.requestMatchers("/member/*").hasRole("ADMIN");

		http.formLogin(); // 사용자 인증은 폼로그인 방식을 사용 // 폼 기반 로그인, OAuth2, JWT 토큰 등 다양한 인증 방법 지원
		http.csrf().disable(); // csrf 비활성화
		http.logout(); // 로그아웃처리

		http.formLogin().loginPage("/customlogin") // 로그인 화면 주소
				.loginProcessingUrl("/login") // 로그인 처리 주소
				.successHandler( // 로그인 후 주소가 이상한 곳으로 튀는 경우가 있어서 핸들러를 통해 성공 후 처리를 어떻게 할건지 정해줌
						new AuthenticationSuccessHandler() {
							@Override
							public void onAuthenticationSuccess(HttpServletRequest request,
									HttpServletResponse response, Authentication authentication)
									throws IOException, ServletException {
								response.sendRedirect("/");
							}
						})
				.permitAll(); // 로그인 성공 후 후처리

		return http.build();
	}

	// 패스워드 인코더 객체를 빈으로 등록하는 메소드
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // 패스워드 암호화 할때 사용 하는.... 암호화 엔진의 종류
	}
}
