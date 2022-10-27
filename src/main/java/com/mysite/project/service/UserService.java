package com.mysite.project.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.project.model.User;
import com.mysite.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	//User 서비스에는 User 리포지터리를 사용하여 User 데이터를 생성하는 create 메서드를
	
	public User create(String username, String email, String password) {
	
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		/*
		 * BCryptPasswordEncoder 객체를 직접 생성하여 사용하지 않고 
		 * 빈으로 등록한 PasswordEncoder 객체를 주입받아 사용하도록 수정했다. => 시큐리티 부분에 생성
		 * */
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
		
	}
}
