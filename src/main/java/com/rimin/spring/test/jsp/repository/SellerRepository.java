package com.rimin.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {
	
	public int insertSeller(
							@Param("nickname")String nickname
							, @Param("profileImage") String profileImage
							, @Param("temperature") String temperature);
	
	
}
