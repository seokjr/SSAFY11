<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
<style>
#movie-list {
	border-collapse: collapse;
	width: 100%;
}

#movie-list td, #movie-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
<%--분리한 header.jsp 가져오기 --%>
	<h1>영화 목록</h1>
	<%-- 사용자 수 등록되어있다면 출력하기 --%>
	<c:if test="${not empty movies}">
		<h2>지금까지 등록한 영화 수 : ${movieCount}</h2>
	</c:if>
	<table id="movie-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>감독</th>
				<th>개요</th>
				<th>상영시간</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 등록된 자료를 반복문을 이용해 출력한다. 테이블의 구성은 위 thead 참고 --%>
			<c:forEach items="${movies}" var="movie" varStatus="vs">
				<tr>
					<td>${movie.id}</td>
					<td>${movie.title}</td>
					<td>${movie.director}</td>
					<td>${movie.genre}</td>
					<td>${movie.runningTime}분</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>