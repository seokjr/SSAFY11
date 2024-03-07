<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="./fail.jsp" %>
<!-- 여기에 import를 해줘야한다. -->
<%-- <%@ page import="com.ssafy.dto.User" %> --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판로그인사이트</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
	<h1>로그인</h1>
	<form method="post" action="../user">
		<fieldset>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<!-- 여기를 로그인으로 바꿨으니 servlet에서도 login으로 바꿔줘야 한다. -->
		<input type="hidden" name="action" value="login">
		<input type="text" id="id" name="id" placeholder="아이디입력"><br>
		<input type="password" id="password" name="password" placeholder="비밀번호입력"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시">
		<a href="../index.jsp">홈으로</a>
		</fieldset>
	</form>
</body>
</html>