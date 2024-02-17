package com.rimin.spring.test.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.test.jstl.domain.Weather;
import com.rimin.spring.test.jstl.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> getWeatherList() {
		
		List<Weather> weatherList = weatherRepository.callWeatherList();
		
		return weatherList;
	}
	
	
	
	
	
	
}
