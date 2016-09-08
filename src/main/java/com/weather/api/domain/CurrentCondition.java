package com.weather.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "current_condition")
public class CurrentCondition implements Serializable {

	private String currentTemperature;
	private String weatherIconUrl;
	private String windspeedKmph;
	private String humidity;
	private String visibility;
	private String pressure;
	private String FeelsLikeC;

	@XmlElement(name = "temp_C")
	public String getCurrentTemperature() {
		return currentTemperature;
	}

	@XmlElement(name = "weatherIconUrl")
	public String getWeatherIconUrl() {
		return weatherIconUrl;
	}

	@XmlElement(name = "windspeedKmph")
	public String getWindspeedKmph() {
		return windspeedKmph;
	}

	@XmlElement(name = "humidity")
	public String getHumidity() {
		return humidity;
	}

	@XmlElement(name = "visibility")
	public String getVisibility() {
		return visibility;
	}

	@XmlElement(name = "pressure")
	public String getPressure() {
		return pressure;
	}
	@XmlElement(name = "FeelsLikeC")
	public String getFeelsLikeC() {
		return FeelsLikeC;
	}

	public void setCurrentTemperature(String currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public void setWeatherIconUrl(String weatherIconUrl) {
		this.weatherIconUrl = weatherIconUrl;
	}

	public void setWindspeedKmph(String windspeedKmph) {
		this.windspeedKmph = windspeedKmph;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public void setFeelsLikeC(String feelsLikeC) {
		FeelsLikeC = feelsLikeC;
	}

}
