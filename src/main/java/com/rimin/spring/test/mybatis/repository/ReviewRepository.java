package com.rimin.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	// id가 3인 행 조회 리턴
	
	public Review selectReview(@Param("id") int id);
	
	
}
