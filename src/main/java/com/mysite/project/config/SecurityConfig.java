package com.mysite.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

/* 시큐리티 재설정
 * 
 * 
 * @EnableWebSecurity는 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션이다.
 * */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//시큐리티 예외처리 
		http.csrf().disable();
		
//		http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().ignoringAntMatchers("/h2-console/**").and()
//				.headers()
//				.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
//		
		return http.build();
	}
	
	//PasswordEncoder 빈(bean)을 만드는 가장 쉬운 방법은 @Configuration이 적용된 SecurityConfig에 @Bean 메서드를 생성
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
