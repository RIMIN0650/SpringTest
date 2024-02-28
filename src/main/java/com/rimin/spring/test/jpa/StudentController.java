package com.rimin.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jpa.domain.Student;
import com.rimin.spring.test.jpa.repository.StudentRepository;
import com.rimin.spring.test.jpa.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// 비추
	// controller에서는 repository 객체 사용 금지
	// 편의를 위해 잠시 사용 아무리 미미해도 service 사용해야함
	@Autowired
	private StudentRepository studentRepository;
	
	
	@GetMapping("/jpa/student/create")
	@ResponseBody
	public Student createStudent(){
		// 권민석, 010-9758-0540, chris0540@naver.com, 화가
		Student student = studentService.addStudent("권민석", "010-9758-0540", "chris0540@naver.com", "화가");
		
		return student;
	}
	
	
	// id가 3인 학생정보의 장래희망을 강사로 변경
	@GetMapping("/jpa/student/update")
	@ResponseBody
	public Student updateStudent() {
		Student student = studentService.updateStudent(3, "강사");
		return student;
	}
	
	
	@GetMapping("/jpa/student/delete")
	@ResponseBody
	public String deleteStudent(){
	
		studentService.deleteStudent(3);
		
		return "삭제성공";
	}
	
	@GetMapping("/jpa/student/select")
	@ResponseBody
	public List<Student> selectStudent(){
		
		// 모든 행 조회
		// List<Student> studentList = studentRepository.findAll();

		// id 기반 모든 행 내림차순으로 조회
		// List<Student> studentList = studentRepository.findAllByOrderByIdDesc();
		
		// id 기준 내림차순 정렬 후 하나만 조회
		//List<Student> studentList = studentRepository.findTop1ByOrderByIdDesc();
		
		// name 이 "유재석"인 컬럼 조회
		//List<Student> studentList = studentRepository.findByName("유재석");
		
		
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("조세호");
//		
//		List<Student> studentList = studentRepository.findByNameIn(nameList);
//		
		
		// email 주소 중 "naver" 가 포함된 이메일 가진 행 조회
		//List<Student> studentList = studentRepository.findByEmailContaining("naver");
		
		// 3~5 값 조회 > 3, 4, 5 조회
		//List<Student> studentList = studentRepository.findByIdBetweenOrderByIdDesc(3, 5);
		
		// 이름은 findbydreamjob이지만 전혀 상관 없음 query 통해 select 수행
		List<Student> studentList = studentRepository.findByDreamJobQuery("모델");
		
		
		
		
		return studentList;
	}
	
	
}
