package com.weather.api.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hourly")
public class Hourly {
	private String time;
	private String tempC;
	private String windspeedKmph;
	private String winddir16Point;
	private String weatherIconUrl;
	private String lang_ru;
	private String humidity;
	private String visibility;
	private String pressure;
	private String cloudcover;
	private String chanceofrain;
	private String secontTime;
	

	public String getSecontTime() {
		return secontTime;
	}

	public void setSecontTime(String secontTime) {
		this.secontTime = secontTime;
	}

	@XmlElement(name = "time")
	public String getTime() {
		return time;
	}

	@XmlElement(name = "tempC")
	public String getTempC() {
		return tempC;
	}

	@XmlElement(name = "windspeedKmph")
	public String getWindspeedKmph() {
		return windspeedKmph;
	}

	@XmlElement(name = "winddir16Point")
	public String getWinddir16Point() {
		return winddir16Point;
	}

	@XmlElement(name = "weatherIconUrl")
	public String getWeatherIconUrl() {
		return weatherIconUrl;
	}

	@XmlElement(name = "lang_ru")
	public String getLang_ru() {
		return lang_ru;
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

	@XmlElement(name = "cloudcover")
	public String getCloudcover() {
		return cloudcover;
	}

	@XmlElement(name = "chanceofrain")
	public String getChanceofrain() {
		return chanceofrain;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	public void setWindspeedKmph(String windspeedKmph) {
		this.windspeedKmph = windspeedKmph;
	}

	public void setWinddir16Point(String winddir16Point) {
		this.winddir16Point = winddir16Point;
	}

	public void setWeatherIconUrl(String weatherIconUrl) {
		this.weatherIconUrl = weatherIconUrl;
	}

	public void setLang_ru(String lang_ru) {
		this.lang_ru = lang_ru;
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

	public void setCloudcover(String cloudcover) {
		this.cloudcover = cloudcover;
	}

	public void setChanceofrain(String chanceofrain) {
		this.chanceofrain = chanceofrain;
	}

}
