package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals("insertSuccessfull")) {
				message= "Insert success";
				alert = "success";
			} else if (message.equals("updateSuccessfull")) {
				message = "Update success";
				alert = "success";
			} else if (message.equals("deleteSuccessfull")) {
				message = "Delete success";
				alert = "success";
			} else if (message.equals("errorSystem")) {
				message = "Error system";
				alert = "danger";
			}
			request.setAttribute("messageResponse", message);
			request.setAttribute("alert", alert);
		}
	}
}
