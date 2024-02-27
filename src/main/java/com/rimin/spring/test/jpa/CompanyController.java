package com.rimin.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jpa.domain.Company;
import com.rimin.spring.test.jpa.service.CompanyService;

@Controller
public class CompanyController {

	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/jpa/company/create")
	@ResponseBody
	public List<Company> createCompany(){
		
		List<Company> companyList = new ArrayList<Company>();
		
		Company company = companyService.addCompany("넥슨", "컨텐츠 게임", "대기업", 3585);
		companyList.add(company);
		company = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6934);
		companyList.add(company);
		
		return companyList;
	}
	
	
	//규모를 중소기업, 사원수를 34명 으로 수정하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
	updateCompany(){
		
	}
	
	
	
	
}
