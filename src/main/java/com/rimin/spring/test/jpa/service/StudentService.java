package com.rimin.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.jpa.domain.Student;
import com.rimin.spring.test.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber,
			String email, String dreamJob){
		
		
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		// 괄호 안에 있는 단어들은 parameter 이름
		
		
		student = studentRepository.save(student);
		
		
		return student;
	}
	
	
	// 특정 id의 학생정보 중 전달된 장래희망으로 수정하는 기능
	public Student updateStudent(int id, String dreamJob) {
		// update 대상을 조회
		// 조회된 객체에서 수정사항을 적용.
		// 해당 객체를 저장
		
		
		// Optional
		// null 일수도 있는 객체를 리턴할 때 쓰이는 클래스
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder().dreamJob(dreamJob).build();
		
		student = studentRepository.save(student);
		
		return student;
	}
	
	
	public void deleteStudent(int id){
		// 삭제 대상 행을 조회한다.
		// 조회된 객체를 통해 삭제한다.
		
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
		
	}
	
	
	
	
	
	
	
	
	
	
}
