package com.rimin.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.jsp.repository.UserRepository;




@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String name, String birthday, String email) {
		
		int count = userRepository.insertUser(name, birthday, email);
		
		return count;
		
	}
	
	
	
	
}
