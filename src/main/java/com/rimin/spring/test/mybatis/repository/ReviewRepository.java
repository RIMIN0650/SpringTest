package com.rimin.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	// id가 3인 행 조회 리턴
	
	public Review selectReview(@Param("id") int id);
	
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review
			);
	
	
	
	
	//insert 이후 실행된 행의 개수가 return 되므로 return type 은 int 로 
	public int insertReviewByObject(Review review);
	
	
}
