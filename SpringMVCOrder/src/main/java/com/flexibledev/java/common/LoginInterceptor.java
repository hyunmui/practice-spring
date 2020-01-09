package com.flexibledev.java.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Check Session
		HttpSession session = request.getSession(false);
		if (session == null) {
			// Go to login page
			response.sendRedirect("/login.do");
			return false;
		}
		
		// No User Id
		String userId = (String)session.getAttribute("userId");
		if (userId == null) {
			// Go to login page
			response.sendRedirect("/login.do");
			return false;
		}
		
		return true;
	}
	
}
