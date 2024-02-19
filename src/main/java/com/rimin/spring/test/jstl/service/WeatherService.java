package com.rimin.spring.test.jstl.service;

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
	
	
	
	public int insertWeatherHistory(String date, String weather, double temperatures
									, double precipitation, String microDust, double windSpeed) {
		// 추가하는 과정에서 실행된 행의 개수를 얻어오기 위해 return type 을 int 로 잡아줌
		int count = weatherHistoryRepository.putWeatherList(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return count;
		
	}
	
	
	
	
}
