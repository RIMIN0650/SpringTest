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
//	@GetMapping("/info")
//	public String sellerInfo(Model model) {
//		
//		Seller seller = sellerService.getLastSeller();
//		
//		model.addAttribute("result", seller);
//		model.addAttribute("title", "판매자 정보");
//		
//		return "/jsp/sellerInfo";
//	}
	
	@GetMapping("/info")
	public String sellerInfo(@RequestParam(value="id",required=false) Integer id, Model model) {
		// null을 int로 변환할 수 없으므로 id를 null을 저장할 수 있는 타입으로 변환해주기
		// int > Integer
		
		Seller seller = null;
		// id가 전달되면 일치하는 판매자 정보를 표현
		// id가 전달되지 않으면 가장 최근 등록된 판매자 정보를 보여줌
		if(id != null) {
			seller = sellerService.findSeller(id);
		}
		else {
			seller = sellerService.getLastSeller();
			model.addAttribute("title", "판매자 정보");
		}
		model.addAttribute("result", seller);
		return "/jsp/sellerInfo";
	}
	
	// id parameter가 없는 경우 > 가장 최근에 추가된 seller의 정보를 출력
	// 있는 경우 > id 를 parameter로 받아서 해당하는 seller 출력
	
	  @GetMapping("/search") 
	  public String searchSellerById(@RequestParam("id") int id, Model model) { 
		  Seller seller = sellerService.findSeller(id);
		  
		  model.addAttribute("result", seller);
		  // seller 변수가 사용되어야 하니까 매개채가 필요
		  //model 객체를 만들어서 사용
		  //아래 jsp 에서 사용할 데이터를 조회해서 모델 안에 넣어줘야함
		  //request parameter와 일치하는 판매자 정보 얻어오는 서비스를 통해 가져와야 함
		  // 서비스에 있는 메소드를 통해 호출
		  // id를 기반으로 조회해서 판매자 정보 return 해주는 메소드
		  return "/jsp/sellerInfo";
	  }
	 
	
}
