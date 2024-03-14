<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
<style>
table {
	border: 1px solid black;
	width: 90%;
}

/* tr, th, td {
	border: 2px solid black;
}
 */
th:nth-child(1) {
	width: 100px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div>
		<h1>영화 목록</h1>
		<%-- request 영역에 users로 등록된 리스트를 반복문을 이용해 출력한다. --%>
		<table id="movie-list">
			<thead>
				<tr>
					<th>영화번호</th>
					<th>제목</th>
					<th>감독</th>
					<th>장르</th>
					<th>상영시간</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${movies}" var="movie" varStatus="vs">
					<tr>
						<td>${movie.id}</td>
						<td>${movie.title}</td>
						<td>${movie.director}</td>
						<td>${movie.genre}</td>
						<td>${movie.runningTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="./index">홈으로</a><br> <a href="./regist">추가등록</a>
	</div>

</body>
</html>