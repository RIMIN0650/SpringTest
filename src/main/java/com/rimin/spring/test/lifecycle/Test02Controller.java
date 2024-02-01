package com.rimin.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody
@RequestMapping("lifecycle/test01")
public class Test02Controller {

	
	@RequestMapping("/4")
	public List<Map<String, Object>> movieList(){
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movieInfo = new HashMap<>();
		movieInfo.put("rate", 15);
		movieInfo.put("director", "봉준호");
		movieInfo.put("time",131);
		movieInfo.put("title", "기생충");
		movieList.add(movieInfo);
		
		Map<String, Object> movieMap2 = new HashMap<>();
		movieMap2 = new HashMap<>();
		movieMap2.put("rate", 0);
		movieMap2.put("director", "로베르토 베니니");
		movieMap2.put("time",116);
		movieMap2.put("title", "인생은 아름다워");
		movieList.add(movieMap2);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 12);
		movieInfo.put("director", "크리스토퍼 놀란");
		movieInfo.put("time",147);
		movieInfo.put("title", "인셉션");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 19);
		movieInfo.put("director", "윤종빈");
		movieInfo.put("time",133);
		movieInfo.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 15);
		movieInfo.put("director", "프란시스 로렌스");
		movieInfo.put("time",137);
		movieInfo.put("title", "헝거게임");
		movieList.add(movieInfo);
		
		return movieList;
	}
	
	
	@RequestMapping("/5")
	public List<Map<String, String>> guestList(){
		List<Map<String,String>> guest = new ArrayList<>();
		
		guest.add(user1());
		guest.add(user2());
		guest.add(user3());
		
		
		return guest;
	}
	
	
	public Map<String, String> user1(){
		
		Map<String, String> user1 = new HashMap<>();
		user1.put("title", "안녕하세요 가입인사 드립니다");
		user1.put("user", "hangulu");
		user1.put("content", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		return user1;
	}
	public Map<String, String> user2(){
		
		Map<String, String> user2 = new HashMap<>();
		user2.put("title", "헐 대박");
		user2.put("user", "bada");
		user2.put("content", "오늘 목요일이었어... 금요일인줄");
		
		return user2;
	}
	public Map<String, String> user3(){
		
		Map<String, String> user3 = new HashMap<>();
		user3.put("title", "오늘 데이트 한 이야기 해드릴게요.");
		user3.put("user", "dulumary");
		user3.put("content", "...");
		
		return user3;
	}
	
	@RequestMapping("/6")
	public List<Post> postList(){
	
		List<Post> postList = new ArrayList<>();
		Post post = new Post("안녕하세요. 가입인사 드립니다", "hagulu", "안녕하세요 가입했어요 잘부탁");
		
		postList.add(post);
		
		post = new Post("헐 대박", "bada", "오늘 목요일이었어, 금요일인줄");
		postList.add(post);
		
		post = new Post("asdf", "1234", "xzicvidif");
		postList.add(post);
		
		
		return postList;
	}
	
	@RequestMapping("/8")
	public ResponseEntity<Post> postError(){
		Post post = new Post("asdf", "1234", "xzicvidif");
		ResponseEntity<Post> entity = new ResponseEntity<>(post, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		return entity;
	}
	
	
}
