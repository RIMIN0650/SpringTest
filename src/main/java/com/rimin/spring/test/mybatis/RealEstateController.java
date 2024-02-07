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
	
	
	@RequestMapping("/4")
	@ResponseBody
	public String createRealEstate() {
		// 3, 푸르지용 리버 303동 1104호, 89, 매매, 100000
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstateByObject(realEstate);
		return "입력 성공 : " + count;
	}
	
	
	
	
	//주소창에서 realtorId 파라미터로 전달받기 
	// localhost:8080/mybatis/real-estate/select/5?realtorid=3
	@RequestMapping("/5")
	@ResponseBody
	// field 로 insert 하기
	public String insertRealEstate(@RequestParam("realtorId")int realtorId) {
		int count = realEstateService.addRealEstate(realtorId, "샹떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 : " + count;
	}
	
	
	
	
	
	
	
	
	
	
}
