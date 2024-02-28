package com.rimin.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.jpa.domain.Company;
import com.rimin.spring.test.jpa.repository.CompanyRepository;
@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	
	public Company addCompany(String name, String business, String scale, int headcount){
		// insert 된 결과로 그 행의 모든 정보 저장된 행을 return 
		Company company = Company.Builder()
							.name(name) // .멤버변수 이름 (저장할 값)   전달할 값을 파라미터로 입력받음
							.business(business) // 괄호 안은 파라미터로 전달될 값
							.scale(scale)
							.headcount(headcount)
							.build(); // 필요한 값 세팅 후에 작성
				// 굳이 다 채우지 않아도 됨 원하는 만틈만 사용 가능
		
		company = companyRepository.save(company);
		// save 인자로 entity class에 변수 채워진
		// save : insert query 수행
		// insert 후의 객체 돌려줌
		
		return company;
		
	}
	
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		// optional 이라는 객체로 감싸져서 return
		Company company = optionalCompany.orElse(null);
		// null 처리 
		// null 인 경우 괄호 안에 있는 null return
		if(company != null) {
			// null 이 아닌 경우만 수정 진행
			// 해당 객체만 수정
			// 그 객체값을 저장해달라고 요청
			company = company.tobuilder().scale(scale).headcount(headcount).build();
			// 해당 객체의 값을 수정하기
			company = companyRepository.save(company);
			// 해당 객체를 다시 저장 , entity 객체로 return 
		}
		

		return company;
	}
	
	
	public void deleteCompany(int id) {
		// 삭제할 대상 행의 객체를 얻는다
		
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		// 행에 대응되는 entity 객체 return 
		
		Company company = optionalCompany.orElse(null);
		// null일 경우가 있으므로 
		
		if(company != null) {
			// null이 아닐때만
		companyRepository.delete(company);
		// 객체를 기반으로 삭제 진행
		}
		
		//아무것도 리턴해주지 않아서 return type : void
	}
}
