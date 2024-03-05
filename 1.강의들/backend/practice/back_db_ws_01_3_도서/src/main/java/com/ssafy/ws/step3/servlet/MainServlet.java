package com.ssafy.ws.step3.servlet;

import java.io.IOException;

import com.ssafy.ws.step3.dto.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//	      request.getParameter("main");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		}
	}
	
	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		// request 객체에서 전달된 parameter를 추출한다.
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String director = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");

//		// 전달받은 parameter를 이용해서 Book 객체를 생성한다. 
		Book book = new Book(isbn, title, director, price, desc);

//		// 화면에 출력할 데이터를 구성한다. 
		StringBuilder output = new StringBuilder();

		output.append("<html><body>").append("<h1>입력 내용</h1>").append(book.toString()).append("</body></html>");

		// response 객체를 통해서 생성한 html코드를 출력한다.
		// 응답이 어떤 타입인지 설정
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(output.toString());

	}
}
