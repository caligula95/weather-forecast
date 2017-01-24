package com.weather.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.weather.api.domain.Astronomy;
import com.weather.api.domain.CurrentCondition;
import com.weather.api.domain.Data;
import com.weather.api.domain.Hourly;
import com.weather.api.domain.NearestArea;
import com.weather.api.domain.Weather;
import com.weather.api.exception.PageErrorException;
import com.weather.api.service.DataMarshalingService;

@Controller
public class WeatherController {

	String url = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=0086a961f9d14110afb171023161912&showlocaltime=yes&num_of_days=7&includelocation=yes&mca=no&tp=3&lang=ru&q=";
	
	@Autowired
	DataMarshalingService data;
	List<Weather> globalWether;
	public String buildUrl(String location) {
		if (location == null || location.equals("")) {
			return url + "Kiev";
		}
		String buidlUrl = "";
		buidlUrl = url + location;
		return buidlUrl;
	}
	
	@RequestMapping(value = "/")
	public String getIndex(Model model) {
			try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sendGet = data.sendGet("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=0086a961f9d14110afb171023161912&showlocaltime=yes&num_of_days=7&includelocation=yes&mca=no&tp=3&lang=ru&q=Kiev");
			try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Data dat = data.unmarshalData(sendGet);
		CurrentCondition currentCondition = dat.getCurrentCondition();
		NearestArea nearestArea = dat.getNearestArea();
		List<Weather> weather = dat.getWeather();
		if (currentCondition == null || nearestArea == null || weather == null) {
			throw new PageErrorException();
		}
		globalWether = weather;
		for (int i=0; i<weather.size(); i++) {
			weather.get(i).setDay(data.getDay(weather.get(i).getDate()));
		}
		List<Weather> weatherCondition = new ArrayList<Weather>();
		for (int i=1; i<weather.size(); i++) {
			weatherCondition.add(weather.get(i));
		}
		
			model.addAttribute("weather", weatherCondition);
			String localTime = data.unmarshalData(sendGet).getTimeZone().getLocalTime();
			model.addAttribute("localtime", localTime);
			model.addAttribute("currentTemperature", currentCondition.getCurrentTemperature());
			model.addAttribute("day", data.getDay(localTime));
			model.addAttribute("icon", currentCondition.getWeatherIconUrl());
			model.addAttribute("humidity", currentCondition.getHumidity());
			model.addAttribute("wind", currentCondition.getWindspeedKmph());
			model.addAttribute("visibility", currentCondition.getVisibility());
			model.addAttribute("nearestArea", nearestArea);
		return "index";
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String getWeatheByLocation(Model model, HttpServletRequest req, @RequestParam("city") String location) {
		String sendGet = "";
		if (location!=null || location.equals(""))
		 sendGet = data.sendGet(buildUrl(location));
		Data dat = data.unmarshalData(sendGet);
		CurrentCondition currentCondition = dat.getCurrentCondition();
		NearestArea nearestArea = dat.getNearestArea();
		List<Weather> weather = dat.getWeather();
		if (currentCondition == null || nearestArea == null || weather == null) {
			throw new PageErrorException();
		}
		globalWether = weather;
		for (int i=0; i<weather.size(); i++) {
			weather.get(i).setDate(data.getDay(weather.get(i).getDate()));
		}
		List<Weather> weatherCondition = new ArrayList<Weather>();
		for (int i=1; i<weather.size(); i++) {
			weatherCondition.add(weather.get(i));
		}
		String localTime = data.unmarshalData(sendGet).getTimeZone().getLocalTime();
		model.addAttribute("weather", weatherCondition);
		model.addAttribute("localtime", localTime);
		model.addAttribute("currentTemperature", currentCondition.getCurrentTemperature());
		model.addAttribute("day", data.getDay(localTime));
		model.addAttribute("icon", currentCondition.getWeatherIconUrl());
		model.addAttribute("humidity", currentCondition.getHumidity());
		model.addAttribute("wind", currentCondition.getWindspeedKmph());
		model.addAttribute("visibility", currentCondition.getVisibility());
		model.addAttribute("nearestArea", nearestArea);
		return "index";
	}
	
	@RequestMapping("/byip")
	public String getWeatherByIp(Model model, HttpServletRequest request) {
		String location = request.getRemoteAddr();
		System.out.println(location);
		String sendGet = "";
		if (location!=null || location.equals(""))
		 sendGet = data.sendGet(buildUrl(location));
		System.out.println(buildUrl(location));
		Data dat = data.unmarshalData(sendGet);
		CurrentCondition currentCondition = dat.getCurrentCondition();
		NearestArea nearestArea = dat.getNearestArea();
		List<Weather> weather = dat.getWeather();
		if (currentCondition == null || nearestArea == null || weather == null) {
			throw new PageErrorException();
		}
		globalWether = weather;
		for (int i=0; i<weather.size(); i++) {
			weather.get(i).setDate(data.getDay(weather.get(i).getDate()));
		}
		List<Weather> weatherCondition = new ArrayList<Weather>();
		for (int i=1; i<weather.size(); i++) {
			weatherCondition.add(weather.get(i));
		}
		String localTime = data.unmarshalData(sendGet).getTimeZone().getLocalTime();
		model.addAttribute("weather", weatherCondition);
		model.addAttribute("localtime", localTime);
		model.addAttribute("currentTemperature", currentCondition.getCurrentTemperature());
		model.addAttribute("day", data.getDay(localTime));
		model.addAttribute("icon", currentCondition.getWeatherIconUrl());
		model.addAttribute("humidity", currentCondition.getHumidity());
		model.addAttribute("wind", currentCondition.getWindspeedKmph());
		model.addAttribute("visibility", currentCondition.getVisibility());
		model.addAttribute("nearestArea", nearestArea);
		return "index";
		
	}
	

	
	@RequestMapping("/detail/{date}") 
	public String getWeather(Model model, @PathVariable("date") String date) {
		List<Hourly> hourly = null;
		Astronomy astronomy = null;
		String weatherDay = "";
		String weatherDate = "";
		for (int i=0; i<globalWether.size(); i++) {
			if (globalWether.get(i).getDate().equals(date)) {
				weatherDay = globalWether.get(i).getDay();
				weatherDate = globalWether.get(i).getDate();
				hourly = globalWether.get(i).getHourly();
				astronomy = globalWether.get(i).getAstronomy();
			}
		}
		for (int i=0; i<hourly.size(); i++) {hourly.get(i).setSecontTime(((Integer.parseInt(hourly.get(i).getTime())/300)*3)+3+"");
			hourly.get(i).setTime((Integer.parseInt(hourly.get(i).getTime())/300)*3+"");
			
		}
		model.addAttribute("day", weatherDay);
		model.addAttribute("date", weatherDate);
		model.addAttribute("astronomy", astronomy);
		model.addAttribute("hourly", hourly);
		return "weather";
	}
	
	@ExceptionHandler(PageErrorException.class)
	public String handleError() {
		return "notFound";
		
	}
	
}
