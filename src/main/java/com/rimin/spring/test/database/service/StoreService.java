package com.rimin.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.database.domain.Store;
import com.rimin.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;
	
	// controller에서 호출한 메소드 호출하는 기능
	// 가게 정보 리스트를 돌려주는 기능
	
	
	public List<Store> getStoreList(){
		
		// store 테이블의 가게 정보 조회 결과를
		// repository 메소드를 통해 얻어온다.
		List<Store> storeList = storeRepository.selectStoreList();
		return storeList;
		
	}
}
