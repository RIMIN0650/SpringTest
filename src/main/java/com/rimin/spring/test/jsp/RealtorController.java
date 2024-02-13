package com.rimin.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rimin.spring.test.jsp.domain.Realtor;
import com.rimin.spring.test.jsp.service.RealtorService;

@Controller
public class RealtorController {

	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/jsp/realtor/info")
	public String insertRealtor(@RequestParam("office")String office
							, @RequestParam("phoneNumber")String phoneNumber
							, @RequestParam("address")String address
							, @RequestParam("grade")String grade
							, Model model) {
		
		Realtor realtor = new Realtor();
		
		
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		
		realtorService.addRealtor(realtor);
		model.addAttribute("result",realtor);
		
		return "/jsp/realtorInfo";
	}
	
	@GetMapping("/jsp/realtor/input")
	public String putRealtor() {
		
		return "/jsp/realtorInput";
		
	}
	
	
	
	
}
