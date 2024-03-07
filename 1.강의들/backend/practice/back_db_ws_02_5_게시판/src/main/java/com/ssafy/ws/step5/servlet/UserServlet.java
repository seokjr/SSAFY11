package com.ssafy.ws.step5.servlet;

import java.io.IOException;

import com.ssafy.ws.step5.dto.User;
import com.ssafy.ws.step5.manager.ArticleManager;
import com.ssafy.ws.step5.manager.UserManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/user 이 필요하다.

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "signup":
			doSignup(request, response);
			break;
		case "login":
			doLogin(request, response);
			break;
		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserManager um = UserManager.getInstance();
		System.out.println(um);
		User user = um.login(id, password);
		System.out.println(user);
		// null이면 로그인 실패 아니면 list 페이지로 넘겨야함.
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/user/fail.jsp");
		} else {
			// 여기도 성공했는데 um을 보내야하는 건지 아닌지 확인
			// 여기서 article manager를 보낸다.
			ArticleManager am = ArticleManager.getInstance();
			request.setAttribute("articleManager", am);
			response.sendRedirect(request.getContextPath() + "/article/list.jsp");
//			RequestDispatcher disp = request.getRequestDispatcher("/article/list.jsp");
//			disp.forward(request, response);
		}
	}

	private void doSignup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		User user = new User();
		user.setUserId(id);
		user.setPassword(password);
		user.setUserName(userName);
		user.setNickName(nickName);
		user.setEmail(email);

		UserManager um = UserManager.getInstance();
		// 회원가입을 성공해서 true가 나오면 login인 페이지로 보내고 안된다면 fail 페이지로 보낸다.
		boolean check = um.signup(user);
		if (check) {
			// 얘를 user를 보내줘야할지 userList를 보내줘야할지 고민해봐야 할 듯
			request.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
//			RequestDispatcher disp = request.getRequestDispatcher("/user/login.jsp");
//			disp.forward(request, response);
		}
		// 실패하니까 redirect로 fail로 보내야 함.
		else {
			response.sendRedirect(request.getContextPath() + "/user/fail.jsp");
		}
	}
}
