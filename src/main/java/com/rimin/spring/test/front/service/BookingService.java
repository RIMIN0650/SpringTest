package com.rimin.spring.test.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.front.domain.Booking;
import com.rimin.spring.test.front.repository.BookingRepository;

@Service
public class BookingService {
	// 한 행의 정보를 얻어오기 
	
	@Autowired
	private BookingRepository bookingRepository;
	
	
	public List<Booking> getBookList() {
		// service 에서 직접 db 조회를 못하니까 그 기능을 수행할 메소드 필요
		// > repository 의 메소드 : db 조회 담당
		
		List<Booking> bookingList = bookingRepository.selectBookList();
		
		return bookingList;
		
	}
	
	
}
