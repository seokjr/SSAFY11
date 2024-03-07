package com.ssafy.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookie extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
		// 쿠키를 생성하자.
		Cookie cookie = new Cookie(key, value);
		// 유효시간 (만료단위) : 초단위
		cookie.setMaxAge(60);
		
		// 쿠키는 remove 메서드 따로 없어요...
//		cookie.setMaxAge(0); // 쿠키를 삭제하는 방법!
		
		// 사용자에게 어떻게 돌려줘!
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath()+"/02_CookieResult.jsp");
	}
}
