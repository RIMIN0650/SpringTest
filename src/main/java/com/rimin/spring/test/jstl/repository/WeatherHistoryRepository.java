package com.rimin.spring.test.jstl.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.test.jstl.domain.Weather;

@Mapper
public interface WeatherHistoryRepository {
	
	
	public List<Weather> selectWeatherHistory();
	
	
	public int putWeatherList(@Param("date")Date date
								, @Param("weather")String weather
								, @Param("temperatures") double temperatures
								, @Param("precipitation") double precipitation
								, @Param("microDust") String microDust
								, @Param("windSpeed") double windSpeed);
	//insert : 실행된 행의 개수 return > int 
	
	public int insertWeatherByObject(Weather weather);
	//전달 받을 값을 특정 객체에 저장되어있는 멤버변수를 통해 query 만들어 낼 수 잇음
	// 그 경우에 param annotation 없이 위와 같이 구성하고
	// 해당하는메소드를 위 repository 와 연결된 mapper를 통해 구현하기
}
