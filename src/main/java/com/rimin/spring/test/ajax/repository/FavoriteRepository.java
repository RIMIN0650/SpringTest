package com.rimin.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	
	public List<Favorite> selectFavoriteList();
	
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
	//삽입된 행의 개수 리턴해주므로 return type : int
	
	
	
	// 즐겨찾기 추가 중복 url 판단
	// 전달받은 url 값을 가진 행의 개수 조회
	// 1 이상이라면 중복된 값임
	// param annotation 안의 값이 xml 안에서 사용할 값
	public int checkDupUrl(@Param("url") String url);
	
	
	//즐겨찾기 삭제
	//insert delete update : 수행된 행의 개수 return > return type : int
	public int deleteStar(@Param("id") int id);
	
	
	
	
	
}
