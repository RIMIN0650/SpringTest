package com.rimin.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rimin.spring.test.database.domain.UsedGoods;

// Mybatis framework 사용
// 데이터베이스 관련 기능 담당

@Mapper
public interface UsedGoodsRepository {
	
	public List<UsedGoods> selectUsedGoodsList();
	
	
}
