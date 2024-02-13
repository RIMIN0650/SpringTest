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
	
	public Seller searchSellerId(@Param("id") int id);
	// param : 해당 어노테이션이 xml에서 어떻게 사용될 것인지
	// 변수값이 사용되는 곳에서 사용될 키워드가 파람 어노테이션 안에 있는 문자열
}
