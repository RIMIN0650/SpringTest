package com.rimin.spring.test.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jpa.domain.Student;
import com.rimin.spring.test.jpa.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
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
	
	
	
}
