package com.rimin.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimin.spring.test.ajax.domain.Favorite;
import com.rimin.spring.test.ajax.service.FavoriteService;

@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	
	@GetMapping("/ajax/favorite/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "/ajax/favorite/favorite";
	}
	
	//url 파라미터 인 경우 유알엘 길어질 수 잇어서 포스트 매핑함
	@PostMapping("/ajax/favorite/create")
	@ResponseBody
	// 응답을 처리하는 방식
	 public Map<String, String> createFavorite(@RequestParam("name") String name
			 		, @RequestParam("url") String url){
		
		int count = favoriteService.addFavorite(name, url);
		
		// 성공 실패 여부를 response에 담아서 알려주기
		// 성공 : {"result" : "success"}
		// 실패 : {"result" : "fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			//성공
			resultMap.put("result","success");
		}else {
			resultMap.put("result",  "fail");
		}
		
		return resultMap;
		
	}
	
	
	
	@GetMapping("/ajax/favorite/input")
	public String inputFavoriteList() {
		
		return "/ajax/favorite/favoriteInput";
	}
	
	
	
	
	
	//즐겨찾기 추가하기 url 중복 체크하기
	@PostMapping("/ajax/favorite/check-duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		boolean isDuplicateUrl = favoriteService.isDuplicateUrl(url);
		
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		
		//중복 : true isduplicateUrl : true
		// 중복 아님 : isDuplicateUrl : false
		
//		if(isDuplicateUrl) {
//			resultMap.put("isDuplicateUrl", true);
//		} else {
//			resultMap.put("isDuplicateUrl",  false);
//		}
		
		resultMap.put("isDuplicateUrl",  isDuplicateUrl);
		
		return resultMap;
		
	}
	
	
	
	@GetMapping("/ajax/favorite/delete")
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		int count = favoriteService.deleteFavorite(id);
		
		// 삭제가 성공 > {"result" : "success"}
		// 실패했으면 > {"result" : "fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		//id 기반 수행 > 성공했을 땐 무조건 1 행 지움
		//> 1이 아니면 무조건 실패
		
		if(count==1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		
		return resultMap;
			
	}
	
	
	
	
	
	
	
	
	
}
