package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	//코드를 작성하세요
	static int id = 0;
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
//		int id = Integer.parseInt(request.getParameter("id"));
		// id는 전달받는게 아니라 등록하면서 바뀌는 거니까 내가 따로 정의해줘야할 듯
		
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
//		// 문자열로 전달된 age는 숫자로 변환
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));
		
//		// 전달받은 parameter를 이용해서 User 객체를 생성한다. 
		Movie movie = new Movie(id, title, director, genre, runningTime);
		id++;
		
//		// 화면에 출력할 데이터를 구성한다. 
		StringBuilder output = new StringBuilder();
		
		output.append("<html><body>").append("<h1>영화 정보</h1>").append(movie.toString()).append("</body></html>");
		
		// response 객체를 통해서 생성한 html코드를 출력한다.
		// 응답이 어떤 타입인지 설정
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(output.toString());
		
	}
}
