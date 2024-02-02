package com.rimin.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.database.domain.UsedGoods;
import com.rimin.spring.test.database.repository.UsedGoodsRepository;

//로직 business 담당
@Service
public class UsedGoodsService {
	//중고물품 게시글 리스트 얻어오는 기능 만들기
	
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	
	// 중고물품 게시글 리스트
	public List<UsedGoods> getUsedGoodsList(){
		
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
	}
}
