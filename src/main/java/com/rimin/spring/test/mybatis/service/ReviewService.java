package com.rimin.spring.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rimin.spring.test.mybatis.domain.Review;
import com.rimin.spring.test.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 전달된 id 를 가진 리뷰 정보 돌려주는 기능
	public Review getReview(int id){
		Review review = reviewRepository.selectReview(id);
		return review;
	// 딱 하나만의 객체를 리턴
	}
	
	//필요한 기능을 메소드로 만들어서 호출하면 됨
	// 이미 만들어진 클래스 안에 기능을 추가함
	
	

	public int addReview(int storeId, String menu, String userName, double point, String review){
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
	}
	
	// insert 는 return type 을 실행된 행의 개수를 전달하기 위해 return type 를 int로 
	// 성공 여부를 확인하기 위해
	public int addReviewByObject(Review review) {
		int count = reviewRepository.insertReviewByObject(review);
		
		return count;
	}
	
	
	
	
}
