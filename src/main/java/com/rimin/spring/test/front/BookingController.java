package com.rimin.spring.test.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rimin.spring.test.front.domain.Booking;
import com.rimin.spring.test.front.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	@GetMapping("/logPension/bookingList")
	public List<Booking> bookList() {
		// 예약 리스트 response 에 담기
		// db 에서 가져와야 하지만 controller 의 역할이 아님
		// 역할 수행하는 곳에 요청 > 예약 리스트 얻어오기 과정 진행되어야 함
		// 데이터 처리하는 logic 부분에만 요청 > service
		
		List<Booking> bookingList = bookingService.getBookList();
		
		return bookingList;
	}
	
	
	
	
	// 리스트 확인하기 위한 페이지
	@GetMapping("/logPension/book-list")
	public String logPension() {
		
		return "/front/reservList";
	}
	
	
	
}
