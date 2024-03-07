<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키생산공장</title>
</head>
<body>
	<h2>현재 내브라우저에 있는 쿠키 정보</h2>
	<!-- 내가 가지고 있는 모든 쿠키를 전부 보여주고 싶어!-->
	<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null){
		for (Cookie c : cookies){
			String key = c.getName();
			String value = c.getValue();
			out.print(key+ ":" + value +"<br/>");
		}
	} else {
		out.print("쿠키 없다");
	}
	%>
	<a href="index.html">홈으로</a>
</body>
</html>