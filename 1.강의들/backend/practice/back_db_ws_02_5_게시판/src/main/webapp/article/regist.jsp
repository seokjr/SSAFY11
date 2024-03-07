<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
	<h1>SSAFY 글등록</h1>
	<form method="post" action="../article">
		<fieldset>
		<legend>글 등록</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="regist">
		<label for="userSeq">유저seq</label>
		<input type="text" id="userSeq" name="userSeq"><br>
		<label for="title">제목</label>
		<input type="text" id="title" name="title"><br>
		<label for="content">설명</label><br>
		<input style="width : 300px; height : 50px" type="text" id="content" name="content"><br>
		<input type="submit" value="등록">
		<button><a href="list.jsp">취소</a></button>
		</fieldset>
	</form>
</body>
</html>