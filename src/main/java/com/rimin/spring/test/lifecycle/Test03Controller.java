package com.rimin.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {
	
	@RequestMapping("lifecycle/test03") // 클라이언트가 요청하는 주소
	public String test03View() {
	
		return "lifecycle/test03"; // jsp 경로
		
	}
	
	
	
}
