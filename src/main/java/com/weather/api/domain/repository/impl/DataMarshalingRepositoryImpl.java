package com.weather.api.domain.repository.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;
import org.xml.sax.InputSource;

import com.weather.api.domain.Data;
import com.weather.api.domain.Weather;
import com.weather.api.domain.repository.DataMarshalingRepository;

@Repository
public class DataMarshalingRepositoryImpl implements DataMarshalingRepository {
	private final String USER_AGENT = "Mozilla/5.0";

	@Override
	public Data unmarshalData(String isa) {
		JAXBContext jc;
		Unmarshaller unmarshaller = null;
		InputSource is = new InputSource(new StringReader(isa));
		Data data = null;
		try {
			jc = JAXBContext.newInstance(Data.class);
			unmarshaller = jc.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			data = (Data) unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public String sendGet(String url) {
		URL obj;
		System.out.println(url);
		StringBuffer response = null;
		try {
			obj = new URL(url);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("Sending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("some url exception");
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("protocol exception");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("couldn't get document");
			e.printStackTrace();
		}

		// print result
		// System.out.println("responce = " + response.toString());
		return response.toString();

	}

	public String getDay(String localTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String[] splitTime = localTime.split(" ");
	//	System.out.println(splitTime[0]);
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

	public String getDays(String url){
		List<Weather> weather = unmarshalData(url).getWeather();
		List<String> date = new ArrayList<String>();
		String days = "";
		for (Weather w: weather) {
			date.add(w.getDate());
			}
		for (int i = 0; i < date.size(); i++) {
			days =  getDay(date.get(i));
			weather.get(i).setDay(days);
		}
		return days;
	}
	
	
	public static void main(String[] args) {
		DataMarshalingRepositoryImpl data = new DataMarshalingRepositoryImpl();
		// data.unmarshalData(data.sendGet(url)).getCurrentCondition().getCurrentCondition().get(0);
	}

}
