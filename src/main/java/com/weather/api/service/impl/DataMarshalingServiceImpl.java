package com.weather.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import com.weather.api.domain.Data;
import com.weather.api.domain.Weather;
import com.weather.api.domain.repository.DataMarshalingRepository;
import com.weather.api.service.DataMarshalingService;

@Service
public class DataMarshalingServiceImpl implements DataMarshalingService {

	@Autowired
	DataMarshalingRepository data;
	
	@Override
	public Data unmarshalData(String is) {
		// TODO Auto-generated method stub
		return data.unmarshalData(is);
	}

	@Override
	public String sendGet(String url) {
		// TODO Auto-generated method stub
		return data.sendGet(url);
	}

	@Override
	public String getDay(String localTime) {
		// TODO Auto-generated method stub
		return data.getDay(localTime);
	}

	@Override
	public String getDays(String url) {
		// TODO Auto-generated method stub
		return data.getDays(url);
	}



}
