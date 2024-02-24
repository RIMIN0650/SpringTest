package com.rimin.spring.test.front;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.front.domain.Booking;
import com.rimin.spring.test.front.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	
	//리스트 불러오기
	@GetMapping("/logPension/bookingList")
	public String bookList(Model model) {
		// 예약 리스트 response 에 담기
		// db 에서 가져와야 하지만 controller 의 역할이 아님
		// 역할 수행하는 곳에 요청 > 예약 리스트 얻어오기 과정 진행되어야 함
		// 데이터 처리하는 logic 부분에만 요청 > service
		
		// 
		
		List<Booking> bookingList = bookingService.getBookList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "/front/reservList";
	}
	
	
	
	
	// 예약 추가하기 위한 페이지
	@GetMapping("/logPension/makeBook")
	@ResponseBody
	public Map<String, String> createBooking(
								@RequestParam("name") String name
								, @DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") Date date // 2024년 2월 12일 =
								, @RequestParam("day") int day
								, @RequestParam("headcount") int headcount
								, @RequestParam("phoneNumber") int phoneNumber) {
	
		
		int count = bookingService.addBook(name, date, day, headcount, name);
		
		// 성공 : {"result" : "sucess"}
		// 실패 : {"result" : "fail"}
		// api : 요청에 대한 응답을 문자열을 전달해줌
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			//성공
			resultMap.put("result",  "success");
		} else {
			// 실패
			resultMap.put("result",  "fail");
		}
		
		return resultMap;
	}
	
	
	// 메인 홈페이지
	@GetMapping("/logPension/main-page")
	public String mainPage() {
		return "/front/mainPage";
	}
	
	
	
	
}
