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
		// 웹 back-end 개발자이고 정규직인 공고를 조회하고 출력
		// List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		// 4. 복합 조건 조회
		// "정규직"이거나 연봉이 9000 이상인 공고를 조회하고 출력
		//	List<Recruit> recruitList = recruitRepository.findByTypeOrSalaryLessThan("정규직", 9000);
		
		
		// 5. 정렬 제한 조건
		// "계약직" 목록을 연봉 기준으로 내림차순으로 3개 조회
		// List<Recruit> recruitList = recruitRepository.findTop3ByOrderBySalaryDesc();

		// 6. 범위 조회 
		// "성남시 분당구" 가 지역인 연봉 "7000"이상 "8500" 이하인 공고를 조회후 출력
		//List<Recruit> recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500) ;
		// List<Recruit> recruitList = recruitRepository.findTop3ByOrderBySalaryDesc();
		
		
		
		List<Recruit> recruitList = recruitRepository.findByTypeAndDeadlineAndSalary("2026-04-10","정규직" , 8100);
		
		return recruitList;
		
	}
	
	
	
	
	
	
}
