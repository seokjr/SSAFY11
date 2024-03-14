package com.ssafy.mvc.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class MyFilter extends HttpFilter implements Filter {
      
	public FilterConfig filterConfig;
	
    // 필터 초기화 하는 과정
    public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
    	this.filterConfig = fConfig;
	}
    //필터 종료될 때
	public void destroy() {
	}

	// 필터 동작과정
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 서버에 가기전 필요한 코드 작성
		System.out.println("서블릿 전1");
		// 다음 필터로 전달! 인데
		// 다음필터가 업서으면 서블릿으로 간다. 없으면 안되는 코드
		String encoding = this.filterConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);// 좋지 않은 방식 직접 바꾸지 마라
		chain.doFilter(request, response);
		// 사용자에게 가기전 필요한 코드 작성
		System.out.println("서블릿 후1");
	}

	

}
