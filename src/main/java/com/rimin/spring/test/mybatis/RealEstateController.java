package com.rimin.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.mybatis.domain.RealEstate;
import com.rimin.spring.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController {

	@Autowired
	public RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public RealEstate estate(@RequestParam("id") int id) {
		RealEstate estate = realEstateService.getEstate(id);
		
		return estate;
	}
	
	
}
