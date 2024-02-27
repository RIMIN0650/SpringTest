package com.rimin.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.spring.test.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	// 1행 삽입 기능 
	// 수정 기능
	// 삭제 기능
	// 모든행 조회 기능
	// primary key 기반 조회 기능
	// 
	
	

}
