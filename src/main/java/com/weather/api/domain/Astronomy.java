package com.weather.api.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "astronomy")
public class Astronomy {
	private String sunrise;
	private String sunset;

	@XmlElement(name = "sunrise")
	public String getSunrise() {
		return sunrise;
	}

	@XmlElement(name = "sunset")
	public String getSunset() {
		return sunset;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

}
