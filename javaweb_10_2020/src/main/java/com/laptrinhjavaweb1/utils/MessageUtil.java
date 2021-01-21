package com.laptrinhjavaweb1.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {
		ResourceBundle mybundle = ResourceBundle.getBundle("message");
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals("insertSuccess")) {
				messageResponse= mybundle.getString(message);
				alert = "success";
			} else if (message.equals("updateSuccess")) {
				messageResponse= mybundle.getString(message);
				alert = "success";
			} else if (message.equals("deleteSuccess")) {
				messageResponse= mybundle.getString(message);
				alert = "success";
			} else if (message.equals("errorSystem")) {
				messageResponse= mybundle.getString(message);
				alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
