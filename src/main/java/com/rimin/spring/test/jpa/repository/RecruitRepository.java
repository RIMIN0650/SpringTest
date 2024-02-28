package com.rimin.spring.test.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	
	
	public List<Recruit> findByTypeOrSalaryLessThan(String type, int salary);
	
	
	public List<Recruit> findTop3ByOrderBySalaryDesc();

	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	
	
	//@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
//	public List<Student> findByDreamJobQuery(@Param("dreamJob") String dreamJob);
	
	
	@Query(value="SELECT * FROM `recruit`" + " WHERE `deadline` >: deadline" + "`type` =:type" + "`salary` >=:salary" + "ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> findByTypeAndDeadlineAndSalary(@Param("deadline") String deadline
														, @Param("type") String type
														, @Param("salary") int salary);
	
	
	
	
	
	
	
	
}
