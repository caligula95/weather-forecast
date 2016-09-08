package com.weather.api.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "weather")
public class Weather {

	private String date;
	private String maxtempC;
	private String mintempC;
	private String day;
	private Astronomy astronomy;
	private List<Hourly> hourly;
	
	
	
	public Astronomy getAstronomy() {
		return astronomy;
	}

	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}

	public List<Hourly> getHourly() {
		return hourly;
	}

	public void setHourly(List<Hourly> hourly) {
		this.hourly = hourly;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@XmlElement(name = "date")
	public String getDate() {
		return date;
	}

	@XmlElement(name = "maxtempC")
	public String getMaxtempC() {
		return maxtempC;
	}

	@XmlElement(name="mintempC")
	public String getMintempC() {
		return mintempC;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMaxtempC(String maxtempC) {
		this.maxtempC = maxtempC;
	}

	public void setMintempC(String mintempC) {
		this.mintempC = mintempC;
	}

}
