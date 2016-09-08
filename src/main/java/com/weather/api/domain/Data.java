package com.weather.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
public class Data implements Serializable {
	
	private TimeZone timeZone;
	private CurrentCondition currentCondition;
	private List<Weather> weather;
	private NearestArea nearestArea;
	
	
	
	@XmlElement(name = "nearest_area")
	public NearestArea getNearestArea() {
		return nearestArea;
	}


	public void setNearestArea(NearestArea nearestArea) {
		this.nearestArea = nearestArea;
	}


	@XmlElement(name = "weather")
	public List<Weather> getWeather() {
		return weather;
	}


	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}


	@XmlElement(name = "current_condition")
	public CurrentCondition getCurrentCondition() {
		return currentCondition;
	}
	

	public void setCurrentCondition(CurrentCondition currentCondition) {
		this.currentCondition = currentCondition;
	}


	@XmlElement(name = "time_zone")
	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
	
	
	
}
