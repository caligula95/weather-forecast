package com.weather.api.xml;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.xml.sax.InputSource;

import com.weather.api.domain.Data;
import com.weather.api.domain.Weather;
import com.weather.api.domain.repository.impl.DataMarshalingRepositoryImpl;

public class Test {

	String url = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=1b57730d4ed44753b94192330161408&showlocaltime=yes&num_of_days=7&q=";
	//  http://api.worldweatheronline.com/premium/v1/weather.ashx?key=1b57730d4ed44753b94192330161408&showlocaltime=yes&num_of_days=4&includelocation=yes&mca=no&tp=24&q=Kiev
	
	public String buildUrl(String location) {
		url = url + location;
		return url;
	}
	
	public String getDay(String localTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String[] splitTime = localTime.split(" ");
		System.out.println(splitTime[0]);
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(splitTime[0]));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			return "Воскресенье";
		case 2:
			return "Понедельник";
		case 3:
			return "Вторник";
		case 4:
			return "Среда";
		case 5:
			return "Четверг";
		case 6:
			return "Пятница";
		case 7:
			return "Субота";
		default:
			return "Some problem with data";
		}
	}
	
	
	
	 
	public static void main(String [] args) throws ParseException {
		Test t = new Test();
		String url = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=1b57730d4ed44753b94192330161408&showlocaltime=yes&num_of_days=7&includelocation=yes&mca=no&tp=6&lang=ru&q=Kiev";
		DataMarshalingRepositoryImpl data = new DataMarshalingRepositoryImpl();
		System.out.println(data.unmarshalData(data.sendGet(url)).getWeather().get(0).getHourly().get(1).getWeatherIconUrl());
	}
}
