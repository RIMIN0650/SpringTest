package com.rimin.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.jsp.domain.Seller;

@Mapper
public interface SellerRepository {
	
	public int insertSeller(
						@Param("nickname")String nickname
						, @Param("profileImage") String profileImage
						, @Param("temperature") double temperature);
	//param annotation 뒤가 파라미터로 전달받는 키워드
	
	
	
	public Seller selectLastSeller();
	
	
	
	public int searchSellerId(@Param("id") int id);
	
}
