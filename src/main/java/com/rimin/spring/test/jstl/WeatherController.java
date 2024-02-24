package com.rimin.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
	public String weatherInsert(
//								@DateTimeFormat(pattern="yyyy년M월d일") @RequestParam("date") Date date 
//								, @RequestParam("weather") String weather
//								, @RequestParam("temperatures") double temperatures
//								, @RequestParam("precipitation") double precipitation
//								, @RequestParam("microDust") String microDust
//								, @RequestParam("windSpeed") double windSpeed
								@ModelAttribute Weather weather 
								// 파라미터로 전달받을 값들이 파라미터 이름과 정확하게 매칭되는 멤버변수를 가진 클래스로 엔티티 클래스
								// Weather class에 있는 전달받고자 하는 파라미터가 정확하게 일치하는 멤버변수를 가진 객체 > 엔티티 클래스
								// 이것을 파라미터로 지정해주고 앞에 ModelAttribute annotation 해주면
								// 전달될 파라미터 이름과 매칭되는 멤버변수에다가 해당하는 파라미터 값을 넣어줌
								// 하나하나 귀찮게 나열할 필요 없이 딱 한 줄 만으로 많은 request parameter 해결할 수 있음
								//
								){
		
	//weatherService.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
	
	weatherService.addWeatherByObject(weather);
	
	//서비스에 weather 객체 통해 날씨 정보 저장하는 기능 하는 것 만들기
		
	return "redirect:/jstl/weather/list";
	}
	
	
	@GetMapping("/jstl/weather/input")
	public String weatherInput() {
		return "/jstl/weather/insertWeather";
	}

}
