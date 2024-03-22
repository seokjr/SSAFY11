<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
<style>
#movie-list {
	border-collapse: collapse;
	width: 100%;
}

#movie-list td, #movie-list th {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
<%@ include file="/include/header.jsp"%>
	<h1>등록된 영화 목록</h1>
    
	<c:if test="${!empty userCount }">
		<h2>지금까지 등록한 영화 수 : ${movieCnt}</h2>
	</c:if>
	<table id="movie-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>감독</th>
				<th>장르</th>
				<th>상영시간</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 users로 등록된 자료를 반복문을 이용해 출력한다. --%>
			<c:forEach items="${movies }" var="movie" varStatus="vs">
				<tr>
					<td>${movie.id }</td>
					<td>${movie.title }</td>
					<td>${movie.director }</td>
					<td>${movie.genre }</td>
					<td>${movie.runningTime }분</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>
