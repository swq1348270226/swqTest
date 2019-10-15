package com.swq.BlogSystem.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUtil {
	public static void redirectLogin(HttpServletRequest request ,HttpServletResponse response,String url) {
		try {
			response.sendRedirect("/BlogSystem/login?redirect="+url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
