package com.rimin.spring.test.jstl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {
	
	
	@GetMapping("/ex01")
	public String ex01() {
		return "/jstl/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// 과일 이름 리스트
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("바나나");
		fruitList.add("귤");
		
		model.addAttribute("fruitList", fruitList);
		
		List<Map<String, Object>> userList = new ArrayList<>();
		
		Map<String, Object> userMap1 = new HashMap<>();
		userMap1.put("name", "권민석");
		userMap1.put("age",25);
		userMap1.put("hobby", "독서");
		
		Map<String, Object> userMap2 = new HashMap<>();
		userMap2.put("name", "까토");
		userMap2.put("age", 2);
		userMap2.put("hobby", "잠자기");
		
		userList.add(userMap1);
		userList.add(userMap2);
		
		model.addAttribute("userList", userList);
		
		return "/jstl/ex02";
		
	
	}
	

	
	
	@GetMapping("/test01")
	public String test01() {
		return "/jstl/test01";
	}
	
	@GetMapping("/test02_1")
	public String test02_1(Model model) {
		List<String> musicRanking = new ArrayList<>();
		musicRanking.add("강남스타일");
		musicRanking.add("벚꽃엔딩");
		musicRanking.add("좋은날");
		musicRanking.add("거짓말");
		musicRanking.add("보고싶다");
		model.addAttribute("musicRanking",musicRanking);
		
		return "/jstl/test02_1";
	}
	
	
	@GetMapping("/test02_2")
	public String test02_2(Model model) {
		List<Map<String, Object>> membership = new ArrayList<>();

		Map<String, Object> member = new HashMap<>();
		member.put("name", "손오공");
		member.put("phoneNumber", "010-1234-5678");
		member.put("grade", "VIP");
		member.put("point", 12040);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "저팔계");
		member.put("phoneNumber", "010-4321-1234");
		member.put("grade", "BASIC");
		member.put("point", 3420);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "사오정");
		member.put("phoneNumber", "010-8888-1111");
		member.put("grade", "GOLD");
		member.put("point", 1530);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "삼장");
		member.put("phoneNumber", "010-0000-1234");
		member.put("grade", "GOLD");
		member.put("point", 8450);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "우마왕");
		member.put("phoneNumber", "010-1111-2222");
		member.put("grade", "BASIC");
		member.put("point", 420);
		membership.add(member);
		
		model.addAttribute("member", membership);
		
		return "/jstl/test02_2";
	}
	
	
}