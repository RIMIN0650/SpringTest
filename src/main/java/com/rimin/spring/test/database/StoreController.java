package com.rimin.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.database.domain.Store;
import com.rimin.spring.test.database.service.StoreService;

@Controller
//요청을 처음 처리하는 부분 
// request 와 response 처리
public class StoreController {

	@Autowired
	private StoreService storeService;
	//
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		// 가게 정보 리스트를 json으로 response에 담는다.
		// 가게정보 리스트를 가져오는건 이 역할이 아님
		// store 관련 ServiceClass 를 통해 가게 정보 리스트를 얻어 온다.
		List <Store> storeList = storeService.getStoreList();
		
		
		return storeList;
	}
}
