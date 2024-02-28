package com.rimin.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jpa.domain.Recruit;
import com.rimin.spring.test.jpa.repository.RecruitRepository;


@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	
	
	@GetMapping("/read/1")
	@ResponseBody
	public Recruit readRecruit(){
		
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;	
	}
	
	
	@GetMapping("/read/2")
	@ResponseBody
	public List<Recruit> selectRecruitByCompanyId(@RequestParam("companyId") int companyId) {
		// http://localhost:8080/jpa/recruit/read/2?companyId=3
		// companyId 를 parameter 3 으로 전달
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		
		return recruitList;
	}
	
	
	@GetMapping("/read/3")
	@ResponseBody
	public List<Recruit> selectRecruit(){
		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		return recruitList;
	}
	

	
	
	
	
}
