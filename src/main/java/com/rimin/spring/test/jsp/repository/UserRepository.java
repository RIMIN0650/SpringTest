package com.rimin.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.jsp.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(
					@Param("name") String name
					, @Param("birthday") String birthday
					, @Param("email") String email);
	
	// User.java 엔티티 클래스를 객체로 전달하는
	public int insertUserByObject(User user);
	
	
	// 가장 최근에 삽입된 행 조회
	public User selectLastUser();
	
	
	
	
	
	
}
