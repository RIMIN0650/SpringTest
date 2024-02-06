package com.rimin.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.mybatis.domain.RealEstate;
import com.rimin.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate/select")
public class RealEstateController {

	@Autowired
	public RealEstateService realEstateService;
	
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate estate(@RequestParam("id") int id) {
		// 파라미터로 전달된 id와 일치하는 매물 정보를 json 으로 response에 담는다
		
		RealEstate estate = realEstateService.getEstate(id);
		
		return estate;
	}
	
	
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> realEstateListByRentPrice(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
		
		
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> realEstateListByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price){
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);
		
		return realEstateList;
	}
	
	

	
	
	
}
