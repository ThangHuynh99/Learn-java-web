package com.laptrinhjavaweb1.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}

	public <T> T toModel(Class<T> tClass) {
		try {
		return new ObjectMapper().readValue(value, tClass);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	// bufferedreader dung de lay du lieu json tu client toi server method 1
	public static HttpUtil of(BufferedReader reader) {
		StringBuffer json = new StringBuffer();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return new HttpUtil(json.toString());
	}
	
	// bufferedreader dung de lay du lieu json tu client toi server method 2
	public static String off(BufferedReader reader) {
		StringBuffer json = new StringBuffer();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return json.toString();
	}

}
