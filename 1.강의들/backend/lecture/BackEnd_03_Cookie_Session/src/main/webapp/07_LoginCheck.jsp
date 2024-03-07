<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 화면을 보여줄게 아니기 때문에 다 지워버렸다. 로그인 처리 용도만 할 친구 --%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

// 실제로는 id / pw 를 이용하여 DB 저장되어 있는 유저가 맞는지를 체크한다.
// 아니면 적어도 Manager라도 있어야 했음. 지금은 없음
// id 자체가 없이 그냥 바로 들어오면 그것조차도 오류
if (id.equals("ssafy") && password.equals("1234")) {
	// 로그인 통과
	// 세션에 정보를 저장할 거에요!
	/* request.getCookies(); */
	// 반복문 돌면서 Jsessionid 쿠키를 찾아서 굳이 메모리에 접근해야하는가?
	/* HttpSession mySession= request.getSession(); */
	// 이름 그냥 session이라고 하면 안되나??
	// jsp 에서는 session을 기본 객체로 가지고 있어서 충돌일어나니까 안된다.
	session.setAttribute("id", id);
	
	/* mySession.setAttribute("id", id); */
	response.sendRedirect("08_Main.jsp");
	// request.getRequestDispatcher("08_Main.jsp").forward(request, response);

} else {
	response.sendRedirect("07_LoginForm.jsp");
	// 로그인 실패
}
%>