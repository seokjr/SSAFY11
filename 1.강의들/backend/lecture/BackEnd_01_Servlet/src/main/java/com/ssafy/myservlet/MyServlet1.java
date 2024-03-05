package com.ssafy.myservlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

// 순수한 클래스 파일 servlet으로 되게 만들 고 싶으면 등록해야한다.
public class MyServlet1 implements Servlet{

	@Override
	public void destroy() {
		//서블릿이 소멸할 때!
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// 서블릿 설정 객체를 반환
		return null;
	}

	@Override
	public String getServletInfo() {
		// 서블릿 정보를 반환
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// 파라미터로 넘겨받은 서블릿 설정파일을 가지고 초기화 하는 작업
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// 요청과 응답을 처리하는 일
		
	}
	

}
