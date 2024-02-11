package com.rimin.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rimin.spring.test.database.domain.Store;

// store 테이블의 모든 행을 조회하고 돌려준다.


@Mapper
public interface StoreRepository {	
	
	public List<Store> selectStoreList();
	
}

