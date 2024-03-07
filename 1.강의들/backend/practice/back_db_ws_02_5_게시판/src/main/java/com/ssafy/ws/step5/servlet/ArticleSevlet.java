package com.ssafy.ws.step5.servlet;

import java.io.IOException;

import com.ssafy.ws.step5.dto.Article;
import com.ssafy.ws.step5.dto.User;
import com.ssafy.ws.step5.manager.ArticleManager;
import com.ssafy.ws.step5.manager.UserManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/article 이 필요하다.

@WebServlet("/article")
public class ArticleSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int articleId;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		case "login":
			doDetail(request, response);
			break;
		}
	}
	
	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserManager um = UserManager.getInstance();
		User user = um.login(id, password);
		// null이면 로그인 실패 아니면 list 페이지로 넘겨야함.
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/user/fail.jsp");
		} else {
			// 여기도 성공했는데 um을 보내야하는 건지 아닌지 확인
			// 여기서 article manager를 보낸다.
			ArticleManager am = ArticleManager.getInstance();
			request.setAttribute("articleManager", am);
			response.sendRedirect(request.getContextPath() + "/article/list.jsp");
		}
	}
	
	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Article article = new Article(articleId++, title, content, userSeq);
	
		ArticleManager am = ArticleManager.getInstance();
		am.insert(article);
		
		response.sendRedirect(request.getContextPath() + "/article/list.jsp");
	}
}
