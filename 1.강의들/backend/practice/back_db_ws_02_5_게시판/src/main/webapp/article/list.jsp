<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.ws.step5.dto.Article" %>
<%@ page import="com.ssafy.ws.step5.manager.ArticleManager" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
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
	<% 
		ArticleManager am = ArticleManager.getInstance(); 
		List<Article> articleList = am.selectAll();
	%>
	<h1>SSAFY 게시판</h1>
	<h2>등록된 게시물들</h2>
	<table>
		<thead>
			<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
			<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			
				<%
					for(Article a : articleList){
						out.print("<tr>");
						out.print("<td>"+a.getArticleId()+"</td>");
						%>
						<td>
						<a href="detail.jsp?articleId=<%=a.getArticleId()%>"><%= a.getTitle()%></a> </td>
						<% 
						out.print("<td>"+a.getUserSeq()+"</td>");
						out.print("<td>"+a.getRegDate()+"</td>");
						out.print("<td>"+a.getViewCnt()+"</td>");
						out.print("</tr>");
					}
				%>
			
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>