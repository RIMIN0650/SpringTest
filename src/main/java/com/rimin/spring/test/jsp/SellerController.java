package com.rimin.spring.test.jsp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jsp.service.SellerService;


@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	
	@GetMapping("/add")
	@ResponseBody
	public String addSeller(
							@RequestParam("nickname")String nickname
							, @RequestParam("profileImage")String profileImage
							, @RequestParam(value="temperatrue", required=false)String temperature
							) {
		int count = sellerService.insertSeller(nickname, profileImage, temperature);
		return "수행 결과 : " + count;
	}
	
	
	
	
	
	
	
	@GetMapping("/input")
	public String inputSeller() {
		
		return "/jsp/sellerInput";
	}
	
	
}
