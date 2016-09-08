package com.weather.api.service;

import java.util.List;

import org.xml.sax.InputSource;

import com.weather.api.domain.Data;
import com.weather.api.domain.Weather;

public interface DataMarshalingService {
Data unmarshalData(String is);
	
	String sendGet(String url);
	
	String getDay(String localTime);
	
	String getDays(String url);
}
