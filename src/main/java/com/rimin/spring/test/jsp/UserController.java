package com.rimin.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.jsp.domain.User;
import com.rimin.spring.test.jsp.service.UserService;


@Controller
@RequestMapping("/jsp/user")
public class UserController {

	@Autowired
	public UserService userService;

	// 이름, 생년월일, 이메일 전달 받고, 저장하는 페이지
	// 4 개의 정보를 request parameter 로 전달받기
	// get : parameter 주소의 형태로
	// post : requestbody 에 넣어서 사용
	//@RequestMapping(path="/jsp/user/create", method=RequestMethod.GET) // GET POST
	//http://localhost:8080/jsp/user/create?name=권민석&birthday=20000323&email=chris0540@naver.com
	@GetMapping("/create") // post로 하고 싶으면 postmapping 사용
	@ResponseBody
	public String createUser(
			@RequestParam("name")String name
			, @RequestParam("birthday")String birthday
			, @RequestParam("email")String email){
		
		int count = userService.addUser(name, birthday, email);
		
		return "수행 결과 : " + count;
	}
	
	
	//특정 위치에 있는 jsp를 html로 만들어서 전달할 수 있도록
	// jsp 경로를 리턴할거라서 string 을 return
	// responsebody 붙이면 문자열로 인식하기 떄문에 붙이지 않음
	@GetMapping("/input")
	public String inputUser() {
		//return "/WEB-INF/jsp/jsp/userInput.jsp";
		// application.properties에 jsp 파일 경로 prefix suffix 설정해뒀기 때문에
		// jsp 경로는 client 가 사용하는 것이 아니고 RequestmMapping / getMapping 통해 접근해야함
		return "/jsp/userInput";
	}
	
	
	
	
	
	
	
	@GetMapping("/info")
	public String userInfo(Model model) {
		//가장 최근에 추가된 사용자 정보
		User user = userService.getLastUser();
		
				// model
		model.addAttribute("result", user);
		model.addAttribute("title", "사용자 정보");
		
		
		
		
		return "/jsp/userinfo";
	}
	
	
	
	
	
}
