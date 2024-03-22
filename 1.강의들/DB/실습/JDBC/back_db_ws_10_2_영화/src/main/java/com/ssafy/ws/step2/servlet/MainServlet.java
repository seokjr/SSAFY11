package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.ssafy.ws.step2.dao.MovieDao;
import com.ssafy.ws.step2.dao.MovieDaoImpl;
import com.ssafy.ws.step2.dto.Movie;

@WebServlet("/main")
public class MainServlet {
	private static final long serialVersionUID = 1L;

	private static int ID = 0;
	private static MovieDao dao = MovieDaoImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request 객체에서 전달된 parameter를 추출한다.
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));

		// 전달받은 파라미터로 Movie 객체를 생성하고, attribute에 등록한다.
		Movie movie = new Movie(ID++, title, director, genre, runningTime);
		request.setAttribute("movie", movie);

		// movieList에 사용자 추가
		try {
			dao.insertMovie(movie);
		} catch (SQLException e) {
         e.printStackTrace();
		}
		// JSP 화면 호출을 위해 RequestDispatcher의 forward를 사용한다.
		// 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context root를 나타낸다.
		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
		disp.forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// attribute에 지금까지 등록한 사용자 리스트 등록
		try {
			request.setAttribute("movies", dao.selectAllMovies());
			request.setAttribute("movieCnt", dao.movieCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// forward를 통해 list.jsp 호출
		RequestDispatcher disp = request.getRequestDispatcher("/list.jsp");
		disp.forward(request, response);
	}
}
