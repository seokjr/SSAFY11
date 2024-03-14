<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>인터셉터</h2>
	<c:choose>
		<c:when test="${empty id}">
			<div><a href="login">로그인 페이지</a></div>
		</c:when>
		<c:otherwise>
			<div>${id}님 반갑습니다. <a href="logout">로그아웃</a></div>
		</c:otherwise>
	</c:choose>
	<div>
		<a href="regist">게시글 등록페이지</a>
	</div>
</body>
</html>