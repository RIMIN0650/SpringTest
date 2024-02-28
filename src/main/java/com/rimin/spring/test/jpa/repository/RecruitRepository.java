package com.rimin.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit,Integer> {
	
	// 1. 아이디기반 조회는 만들필요 없이 바로 조회할 수 있음
	
	// 2. companyId가 일치하는 행 조회
	// WHERE `companyId` = #{companyId}
	// list 안의 객체는 entity 객체가 되어야 하므로 Recruit 으로 잡아줌
	public List<Recruit> findByCompanyId(int companyId);
	
	
	
	
	// 3. positon 컬럼과 type 컬럼이 일치하는 행 조회
	// WHERE `position` = #{position} AND `type` = #{type}
	// public List<Recruit> findByPositonAndType(String position, String type);
	public List< Recruit> findByPositionAndType(String position, String type);
	
	
	
	
	
	
	
	
	
	
	
}
