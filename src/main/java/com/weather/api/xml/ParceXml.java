package com.weather.api.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ParceXml {
	BuildUrl buildUrl = new BuildUrl();

	public String readDoc() throws Exception {
		URL bsu = null;
		String line = "";
		String urlName = buildUrl.baseUrl(buildUrl.getIP());
		try {
			bsu = new URL(urlName);
		} catch (MalformedURLException e) {
			// некорректно заданы протокол, доменное имя или путь к файлу
			e.printStackTrace();
		}
		if (bsu == null) {
			throw new RuntimeException();
		}
		try (BufferedReader d = new BufferedReader(new InputStreamReader(bsu.openStream()))) {

			while ((line = d.readLine()) != null) {
				// System.out.println(line);
				return line;

			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return line;

	}

	public String readXml() throws Exception {
		HttpURLConnectionExample ht = new HttpURLConnectionExample();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = null;
		String sp = readDoc();
		InputSource is = new InputSource(new StringReader(ht.sendGet()));
		try {

			doc = dBuilder.parse(is);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("nearest_area");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;// areaName
				String countr = eElement.getElementsByTagName("country").item(0).getTextContent();
				String nearestArea = eElement.getElementsByTagName("areaName").item(0).getTextContent();
				System.out.println(countr);
				System.out.println(nearestArea);
				return countr + " " + nearestArea;
			}
		}
		return null;
	}

	public String readtime() throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = null;
		String sp = readDoc();
		InputSource is = new InputSource(new StringReader(sp));
		try {
			doc = dBuilder.parse(is);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("time_zone");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;// areaName
				String countr = eElement.getElementsByTagName("localtime").item(0).getTextContent();
				System.out.println(countr);
				return countr;
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		ParceXml te = new ParceXml();
		// te.readXml();
		System.out.println(te.readtime());
		System.out.println(te.readXml());
	}
}
