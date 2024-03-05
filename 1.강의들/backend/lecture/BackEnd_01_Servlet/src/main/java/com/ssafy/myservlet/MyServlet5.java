package com.ssafy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main2")
public class MyServlet5 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 내가 뒤에 적은 걸로 알아들어줘.
		response.setContentType("text/html;characterset=UTF-8");
		// writer를 가져와서 쓰겠다.
		PrintWriter writer = response.getWriter();
		
		writer.write("""
		<html>
		  <head><title>Hello! SSAFY!</title></head>
		  <body>
		    <h1>Hello! MyServlet5!</h1>
		  </body>
		</html>
		""");

	}
}
