package com.rimin.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.rimin.spring.test.jsp.domain.Realtor;

@Mapper
public interface RealtorRepository {
	
	public int addRealtorByObject(Realtor realtor);
	
	
}
