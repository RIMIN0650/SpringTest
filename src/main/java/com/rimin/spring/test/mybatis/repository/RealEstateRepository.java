package com.rimin.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate selectEstate(@Param("id") int id);
	
}
