package com.rimin.spring.test.jstl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.jstl.domain.Weather;
import com.rimin.spring.test.jstl.repository.WeatherHistoryRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherHistoryRepository weatherHistoryRepository;
	
	public List<Weather> getWeatherHistory() {
		
		List<Weather> weatherList = weatherHistoryRepository.selectWeatherHistory();
		
		return weatherList;
	}
	
	
	
	public int insertWeatherHistory(Date date, String weather, double temperatures
									, double precipitation, String microDust, double windSpeed) {
		// 추가하는 과정에서 실행된 행의 개수를 얻어오기 위해 return type 을 int 로 잡아줌
		int count = weatherHistoryRepository.putWeatherList(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return count;
		
	}
	
	public int addWeatherByObject(Weather weather){
		// 해당하는 객체 안에 있는 멤버변수 기반으로 insert query 수행하고
		// 실행된 행의 개수 리턴
		// 객체로 insert 하는 method가 repository 에 없음
		// > 만들기
		
		int count = weatherHistoryRepository.insertWeatherByObject(weather);
		return count;
	}
	
	
}
