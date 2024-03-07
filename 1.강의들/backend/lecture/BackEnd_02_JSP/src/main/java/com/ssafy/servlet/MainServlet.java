package com.ssafy.servlet;

import java.io.IOException;

import com.ssafy.dto.Person;
import com.ssafy.manager.PersonManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("보내");
		
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");

		Person p = new Person(name, age, gender, hobbies);

		PersonManager pm = PersonManager.getInstance(); // 싱글턴이니깐
		pm.regist(p);

		request.setAttribute("person", p);
		
		// 포워드 방식
		RequestDispatcher disp = request.getRequestDispatcher("/12_result.jsp");
		disp.forward(request, response);
		
		// 리다이렉트방식
		// 뜨지 않는 이유는 기존 P는 원래 통로에 있는데 새로 요청해서 다른 통로로
		// 주기 때문에 내 P가 날라가서 나오지 않는 것.
//		response.sendRedirect(request.getContextPath()+"/12_result.jsp");
		
	}
}
