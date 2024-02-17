package com.rimin.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rimin.spring.test.jstl.domain.Weather;
import com.rimin.spring.test.jstl.service.WeatherService;
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/weather/list")
	public String weatherList(Model model) {
		
		List<Weather> WeatherList = weatherService.getWeatherList();
		
		model.addAttribute("weather",WeatherList);
		
		return "/jstl/weather/list";
	}
	
	
	
	
}
