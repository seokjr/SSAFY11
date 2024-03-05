package com.ssafy.lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int initCount = 1;
	int doGetCount = 1;
	int destroyCount = 1;
    public LifeCycle() {
    	System.out.println("생성자호출");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println(initCount++);
		System.out.println("init 호출");
	}

	public void destroy() {
		System.out.println(destroyCount++);
		System.out.println("파괴됨");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(doGetCount++);
		System.out.println("doget호출 ");
	}

}
