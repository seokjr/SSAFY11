<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h2>SSAFY 메인 페이지</h2>

	<c:choose>
		<c:when test="${empty id}">
			<div>
				<a href="login">로그인 페이지</a>
			</div>
		</c:when>
		<c:otherwise>
			${id} 님 반갑습니다. <a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<hr>

	<div>
		<a href="./board/list">자유게시글 조회페이지</a>
	</div>
</body>
</html>