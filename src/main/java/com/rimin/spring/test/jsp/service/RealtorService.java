package com.rimin.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.jsp.domain.Realtor;
import com.rimin.spring.test.jsp.repository.RealtorRepository;

@Service
public class RealtorService {
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		int count = realtorRepository.addRealtorByObject(realtor);
		return count;
	}
	
	
	
}
