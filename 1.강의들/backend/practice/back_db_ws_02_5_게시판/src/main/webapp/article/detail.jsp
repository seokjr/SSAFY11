<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.ws.step5.dto.Article" %>
<%@ page import="com.ssafy.ws.step5.dto.Comment" %>
<%@ page import="com.ssafy.ws.step5.manager.ArticleManager" %>
<%@ page import = "java.util.*" %>
<!-- 게시물 각각을 디테일 하게 보여주는 거 거기다가 댓글 달기도 넣어야 한다. -->
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
		Article article = am.selectOne(Integer.parseInt(request.getParameter("articleId")));
		List<Comment> comments = am.selectArticleComment(article.getArticleId());
	%>
	<h1>SSAFY 게시판</h1>
	<h2><%= article.getTitle() %></h2>
	<div>작성자 : <%= article.getUserSeq() %></div>
	<div>작성일 : <%= article.getRegDate() %></div>
	<div>조회수 : <%= article.getViewCnt() %></div>
	<div>게시글 내용 : <%= article.getContent() %></div>
	<hr>
	
</body>
</html>