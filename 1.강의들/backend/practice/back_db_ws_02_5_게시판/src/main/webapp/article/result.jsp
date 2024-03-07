<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
	<h1>게시물 등록 결과</h1>
	<h2>등록 게시물 정보</h2>
	<%
	if (request.getAttribute("title") == null || request.getAttribute("title").equals("")) {
		out.print("등록된 내용이 없습니다.<br>");
	} else {
		out.print("<table>");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th>항목</th>");
		out.print("<th>내용</th>");
		out.print("</tr>");
		out.print("</thead>");
		out.print("<tbody>");
		out.print("<tr>");
		out.print("<td>도서번호</td>");
		out.print("<td>" + request.getAttribute("isbn") + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>도서명</td>");
		out.print("<td>" + request.getAttribute("title") + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>저자</td>");
		out.print("<td>" + request.getAttribute("author") + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>가격</td>");
		out.print("<td>" + request.getAttribute("price") + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>설명</td>");
		out.print("<td>" + request.getAttribute("desc") + "</td>");
		out.print("</tr>");
		out.print("</tbody>");
		out.print("</table>");
	}
	%>
	<!-- 다시 게시물을 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">게시물 등록</a>
</body>
</html>