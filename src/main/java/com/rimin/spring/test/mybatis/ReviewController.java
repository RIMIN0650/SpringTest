package com.rimin.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.mybatis.domain.Review;
import com.rimin.spring.test.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 전달돤 id를 가진 리뷰정보를 json으로 response에 담는다.
	// request parameter
	// /mybatis/review?id=3
	@RequestMapping("/")
	@ResponseBody
	public Review review(@RequestParam("id") int id) { // String id = request.getParameter("id")
		
		// id가 3인 데이터 조회 > service 를 통해 메소드 호출하기
		Review review = reviewService.getReview(id);
		return review;
		
	}
	
	
	
	
	
	// 리뷰 한 행을 추가하는 기능
	@RequestMapping("/mybatis/review/insert")
	@ResponseBody
	public String createReview() {
		
		// 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛! << 내용 삽입하려함
		// int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");
		
		// 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리입니다! << 내용 삽입하려함
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다");
		
		int count = reviewService.addReviewByObject(review);
		
		
		return "수행결과 : " + count;
		
		
	}
	
}
