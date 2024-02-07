package com.rimin.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.mybatis.domain.RealEstate;
import com.rimin.spring.test.mybatis.repository.RealEstateRepository;


@Service
public class RealEstateService {
	
	@Autowired
	public RealEstateRepository realEstateRepository;
	
	public RealEstate getEstate(int id) {
		RealEstate estate = realEstateRepository.selectEstate(id);
		return estate;
	}
	
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice){
		
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
		return realEstateList;
	}
	
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price){
		List<RealEstate> reviewRepository = realEstateRepository.selectRealEstateListByAreaAndPrice(area,price);
		return reviewRepository;
		
	}
	
	
	
	public int addRealEstateByObject(RealEstate realEstate) {
		// insert의 경우 정수 형태로 리턴해줌
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		return count;
	}
	
	
	
	// realtorId parameter로 전달 field로 insert
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		return count;
	}
	
	
	
	
	
	
	// 특정 id 의 매물 정보에 전달받은 type 과 price 값을 수정하는 기능
	// insert update delete 다 return type int 로 똑같음 실행된 행의 개수 리턴
	public int updateRealEstate(int id, String type, int price) {
		int count = realEstateRepository.updateRealEstate(id, type, price);
		return count;
	}
	
	
	public int deleteRealEstate(int id){
		
		int count = realEstateRepository.deleteRealEstate(id);
		return count;
	}
	
	
}
