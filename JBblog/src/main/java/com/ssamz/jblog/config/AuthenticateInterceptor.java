package com.ssamz.jblog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssamz.jblog.domain.User;

public class AuthenticateInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		// 세션에 회원 정보가 존재하는지 확인
		HttpSession session = request.getSession();
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			response.sendRedirect("/auth/login");
		}
		return true;
	}
}
