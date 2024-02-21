package com.rimin.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jsp.domain.User;
import com.rimin.spring.test.jsp.service.UserService;

@Controller
public class NewUserController {
	
	@Autowired
	private UserService userService;
	
	// response가 html로 화면구성을 위한 페이지
	// view 페이지
	@GetMapping("/ajax/user/list")
	public String userList(Model model) {
		
		// jsp 패키지 안에 service 안에 userService 있으니까 사용
		
		List<User> userList = userService.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "ajax/user/list";
	}
	
	
	// ajax에서 호출하기 위한 목적으로 
	// response가 json 데이터 태인 페이지를 API라고 부름
	@GetMapping("/ajax/user/create")
	@ResponseBody
	public Map<String, String> createUser(
				@RequestParam("name") String name
				, @RequestParam("birthday") String birthday
				, @RequestParam("email") String email) {
	
	// userService에 이미 한 행의 정보를 저장하는 기능이 이미 만들어져있음
		int count = userService.addUser(name, birthday, email);
		
		// 성공 실패 여부
		// 성공 : {"result" : "success"}
		// 실패 : {"result" : "fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			//성공
			resultMap.put("result",  "success");
		} else {
			//실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/ajax/input")
	public String inputUser() {
		return "ajax/user/input";
	}
	
	
	
	
	
}
