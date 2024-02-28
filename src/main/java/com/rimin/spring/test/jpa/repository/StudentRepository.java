package com.rimin.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rimin.spring.test.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	// 1행 삽입 기능 
	// 수정 기능
	// 삭제 기능
	// 모든행 조회 기능
	// primary key 기반 조회 기능
	
	
	// id 기준으로 내림차순 정렬한 모든 행 조회
	// 원래 query 는 ORDER BY `ID` DESC 들어감
	public List<Student> findAllByOrderByIdDesc();
	
	
	// id 기준으로 내림차순 정렬 후 하나만 조회
	// ORDER BY `id` DESC LIMIT 1
	// find : 조회, limit 있으면 find 뒤에 바로 따라옴
	// TOP : Limit 에 들어가는 행의 개수
	public List<Student> findTop1ByOrderByIdDesc();
	
	
	// 전달받은 값과 일치하는 name 컬럼을 가진 행 조회
	// WHERE `name` = #{name}
	public List<Student> findByName(String name);
	// 여러행일 수 있으므로 return type : List
	
	
	
	// 전달받은 값들과 일치하는 name 컬럼을 가진 행 조회
	// WHERE `name` IN('유재석', '조세호')
	public List<Student> findByNameIn(List<String> nameList);
	
	
	// 전달받은 값이 포함된 email 컬럼을 가진 행 조회
	// WHERE `email` LIKE '%naver%'
	public List<Student> findByEmailContaining(String email);
	
	
	// id 컬럼의 값이 특정값 사이에 대응되는 데이터를 id 기준 내림차순으로 조회
	// WHERE `id` BETWEEN 1 AND 7 ORDER BY `id` DESC
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	
	
	// 쿼리를 활용한 조회
	// dreamJob 컬럼이 일치하는 데이터 조회
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> findByDreamJobQuery(@Param("dreamJob") String dreamJob);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
