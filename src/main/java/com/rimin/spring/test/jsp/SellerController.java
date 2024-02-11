package com.rimin.spring.test.jsp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jsp.domain.Seller;
import com.rimin.spring.test.jsp.service.SellerService;


@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	
	@PostMapping("/add")
	@ResponseBody
	public String addSeller(
							@RequestParam("nickname")String nickname
							, @RequestParam("profileImage")String profileImage
							, @RequestParam("temperature")double temperature
							) {
		int count = sellerService.insertSeller(nickname, profileImage, temperature);
		return "수행 결과 : " + count;
	}
	
	
	
	@GetMapping("/input")
	public String inputSeller() {
		
		return "/jsp/sellerInput";
	}
	
	
	
	
	
	//가장 최근에 추가된 seller 정보 출력
	@GetMapping("/info")
	public String sellerInfo(Model model) {
		
		Seller seller = sellerService.getLastSeller();
		
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자 정보");
		
		return "/jsp/sellerInfo";
	}
	
	
	// id parameter가 없는 경우 > 가장 최근에 추가된 seller의 정보를 출력
	// 있는 경우 > id 를 parameter로 받아서 해당하는 seller 출력
	
	  @GetMapping("/search") 
	  public String searchSeller(@RequestParam(value="id", required=false) int id) { 
	  sellerService.findSeller(id); 
	  
	  return " /jsp/sellerInfo ";
	  
	  }
	 
	
}
