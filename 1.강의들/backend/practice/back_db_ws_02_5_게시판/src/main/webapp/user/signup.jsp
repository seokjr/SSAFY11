<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="./fail.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
	<h1>SSAFY 회원가입</h1>
	<form method="post" action="../user">
		<fieldset>
		<legend>회원가입</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<!-- 여기도 signup으로 바꿨다. -->
		<input type="hidden" name="action" value="signup">
		<label for="id">ID</label>
		<input type="text" id="id" name="id"><br>
		<label for="password">비밀번호</label>
		<input type="password" id="password" name="password"><br>
		<label for="userName">이름</label>
		<input type="text" id="userName" name="userName"><br>
		<label for="nickName">닉네임</label>
		<input type="text" id="nickName" name="nickName"><br>
		<label for="email">이메일</label>
		<input type="email" id="email" name="email"><br>
		<input type="submit" value="회원가입">
		<a href="../index.jsp">홈으로</a>
		</fieldset>
	</form>
</body>
</html>