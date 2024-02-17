package com.rimin.spring.test.jstl.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rimin.spring.test.jstl.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	public List<Weather> callWeatherList();
	
	
	
}
