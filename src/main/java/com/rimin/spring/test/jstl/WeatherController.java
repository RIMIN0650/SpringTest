package com.rimin.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.rimin.spring.test.jstl.domain.Weather;
import com.rimin.spring.test.jstl.service.WeatherService;
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/jstl/weather/list")
	public String weatherList(Model model) {
		
		//날씨 리스트 얻어오기
		//컨트롤러가 하는 일이 아니어서 서비스한테 시킴
		//얻어온 리스트를 모델에 세팅
		
	List<Weather> WeatherList = weatherService.getWeatherHistory();
//		
		model.addAttribute("weather",WeatherList);
//		
		return "/jstl/weather/list";
	}
	
	
	
	
	@GetMapping("/jstl/weather/insert")
	//@ResponseBody redirect 위해 responsebody annotation 제거
	public String weatherInsert(@RequestParam("date") String date 
								, @RequestParam("weather") String weather
								, @RequestParam("temperatures") double temperatures
								, @RequestParam("precipitation") double precipitation
								, @RequestParam("microDust") String microDust
								, @RequestParam("windSpeed") double windSpeed) {
		

		
	weatherService.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/jstl/weather/list";
	}
	
	
	@GetMapping("/jstl/weather/input")
	public String weatherInput() {
		return "/jstl/weather/insertWeather";
	}

}
