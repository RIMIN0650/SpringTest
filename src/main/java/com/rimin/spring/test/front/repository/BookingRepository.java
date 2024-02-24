package com.rimin.spring.test.front.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.front.domain.Booking;

@Mapper
public interface BookingRepository {
	
	public List<Booking> selectBookList();
	
	//List : 한 행을 저장하기 위한 
	// generic : 한 행을 저장하기 위한 type
	//domain : 테이블의 한 행의 정보를 모두 저장하기 위한 클래스
	// 그 행의 모든 column의 값을 저장할 수 있는 변수가 필요
	// 테이블 이름과 일치하는 멤버변수 만들어줌
	// 한 행에 있는 모든 정보를 저장하기 위해서는 각각을 구분해서 저장할 수 있도록
	// 해당하는 테이블의 column 이름과 일치하는 member 변수를 가진 class로 만들어감
	// > domain 클래스 or entity 클래스 라고 함
	
	
	public int insertBooking(
			@Param("name") String name
			, @Param("date") Date date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber);
	
}
