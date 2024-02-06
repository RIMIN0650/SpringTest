package com.rimin.spring.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.mybatis.domain.RealEstate;
import com.rimin.spring.test.mybatis.repository.RealEstateRepository;


@Service
public class RealEstateService {
	
	@Autowired
	public RealEstateRepository realEstateRepository;
	
	public RealEstate getEstate(int id) {
		RealEstate estate = realEstateRepository.selectEstate(id);
		return estate;
	}
}