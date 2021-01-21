package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}
	
	public void pushValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	//dung object de ep ve kieu du lieu chung ta mong muon
	public Object getValue(HttpServletRequest request, String key) {	
		return request.getSession().getAttribute(key);
	}
	
	public void deleteValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
	
}
