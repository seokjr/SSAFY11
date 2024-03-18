<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 결과</title>
<style>
main {
	position: absolute; /* 위치를 고정시킴 */
	top: 50%; /* 상단에서 절반 지점으로 이동 */
	left: 50%; /* 화면의 좌측에서 절반 지점으로 이동 */
	transform: translate(-50%, -50%); /* 요소를 가운데로 이동 */
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 3px dotted black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
	</header>

	<main>
		<h1>영화 등록 결과</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>항목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>영화 제목</td>
					<td>${movie.title}</td>
					<c:if test="${not empty movie.img}">
						<td rowspan="5"><img
							src="${pageContext.request.contextPath}/resources/upload/${movie.img}"></td>
					</c:if>
				</tr>
				<tr>
					<td>감독</td>
					<td>${movie.director}</td>
				</tr>
				<tr>
					<td>장르</td>
					<td>${movie.genre}</td>
				</tr>
				<tr>
					<td>상영시간</td>
					<td>${movie.runningTime}</td>
				</tr>
				<c:if test="${not empty movie.img}">
					<tr>
						<td>이미지</td>
						<td>${movie.orgImg}</td>
					</tr>
				</c:if>

			</tbody>
		</table>
		<a href="./regist">추가등록</a> <a href="./list">목록보기</a>
	</main>
</body>
</html>