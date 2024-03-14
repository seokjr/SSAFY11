package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainCotroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("password") String pw) {
//		HttpSession session = request.getSession();
		if (id.equals("ssafy") && pw.equals("1234")) {
			session.setAttribute("id", id);
//			return "index"; // 포워딩
			return "redirect:/";
		}
		// 아니라면 다시 로그인 페이지로 가
		return "redirect:/login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return  "regist";
	}
}
