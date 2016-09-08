package com.weather.api.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nearest_area")
public class NearestArea {
	private String areaName;
	private String country;
	private String region;

	@XmlElement(name = "areaName")
	public String getAreaName() {
		return areaName;
	}

	@XmlElement(name = "country")
	public String getCountry() {
		return country;
	}

	@XmlElement(name = "region")
	public String getRegion() {
		return region;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
