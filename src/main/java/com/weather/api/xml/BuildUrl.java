package com.weather.api.xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class BuildUrl {

	String url = new String("http://api.worldweatheronline.com/premium/v1/weather.ashx?");
	String key = "key=1b57730d4ed44753b94192330161408";
	String q = "q=";
	String num_of_days = "num_of_days=";
	String includelocation = "includelocation=yes";
	String showlocaltime = "showlocaltime=yes";

	public BuildUrl() {

	}

	public String baseUrl(String location) {
		url = url + key + "&" + q + location + "&" + showlocaltime;
		return url;
	}

	public String getIP() {
		try {
			URL url = new URL("http://whatismyip.akamai.com/");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String ipAddress = new String();
			ipAddress = (in.readLine()).trim();
			if (!(ipAddress.length() > 0)) {
				try {
					InetAddress ip = InetAddress.getLocalHost();
					System.out.println((ip.getHostAddress()).trim());
					return ((ip.getHostAddress()).trim());
				} catch (Exception ex) {
					return "ERROR";
				}
			}
			System.out.println("IP Address is : " + ipAddress);
			return (ipAddress);
		} catch (Exception e) {
			try {
				InetAddress ip = InetAddress.getLocalHost();
				System.out.println((ip.getHostAddress()).trim());
				return ((ip.getHostAddress()).trim());
			} catch (Exception ex) {
				return "ERROR";
			}
		}
	}

	public static void main(String[] args) {
		BuildUrl b = new BuildUrl();
		System.out.println(b.url);
		System.out.println(b.baseUrl(b.getIP()));
	}
}
