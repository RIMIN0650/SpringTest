package com.rimin.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.jsp.repository.SellerRepository;


@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	
	public int insertSeller(String nickname, String profileImage, String temperature) {
		int count = sellerRepository.insertSeller(nickname, profileImage, temperature);
		return count;
	}
	
	
	
}
