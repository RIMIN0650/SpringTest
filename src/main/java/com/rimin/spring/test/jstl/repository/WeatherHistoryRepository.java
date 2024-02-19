package com.rimin.spring.test.jstl.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.jstl.domain.Weather;

@Mapper
public interface WeatherHistoryRepository {
	
	
	public List<Weather> selectWeatherHistory();
	
	
	public int putWeatherList(@Param("date")String date
								, @Param("weather")String weather
								, @Param("temperatures") double temperatures
								, @Param("precipitation") double precipitation
								, @Param("microDust") String microDust
								, @Param("windSpeed") double windSpeed);
	//insert : 실행된 행의 개수 return > int 
}
