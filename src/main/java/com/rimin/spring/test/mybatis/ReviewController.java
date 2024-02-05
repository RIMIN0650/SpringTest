package com.rimin.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.mybatis.domain.Review;
import com.rimin.spring.test.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 전달돤 id를 가진 리뷰정보를 json으로 response에 담는다.
	// request parameter
	// /mybatis/review?id=3
	@RequestMapping("/mybatis/review")
	@ResponseBody
	public Review review(@RequestParam("id") int id) { // String id = request.getParameter("id")
		
		// id가 3인 데이터 조회 > service 를 통해 메소드 호출하기
		Review review = reviewService.getReview(id);
		return review;
		
	}
}
