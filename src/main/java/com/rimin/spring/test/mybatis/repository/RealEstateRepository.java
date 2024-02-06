package com.rimin.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate selectEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(@Param("rent") int rentPrice);
	// 메소드는 인터페이스이기 때문에 정의만 해놓음
	
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
	//controller와 repository 는 서로 모르는 사이 아무런 상관이 없음
	
}
