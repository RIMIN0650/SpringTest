package com.rimin.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.ajax.domain.Favorite;
import com.rimin.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavoriteList(){
		//데이터 테이블을 통해 얻음 > 레파지토리 준비
		List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();
		
		return favoriteList;
	}
	
	public int addFavorite(String name, String url) {
		
		int count = favoriteRepository.insertFavorite(name, url);
		
		return count;
		
	}
	
	
	// 즐겨찾기 url 중복 여부 판단
	// true false 를 return 하므로 return type : boolean
	public boolean isDuplicateUrl(String url) {
		int count = favoriteRepository.checkDupUrl(url);
		
//		if(count>0) {
//			return false;
//		} else {
//			return true;
//		}
		
		return count > 0;
		// 연산 결과가 참이면 true 거짓이면 false return
	}
	
	
	
	
	// id로 즐겨찾기 지우기
	public int deleteFavorite(int id) {
		int count = favoriteRepository.deleteStar(id);
		return count;
	}
	
	
	
}
