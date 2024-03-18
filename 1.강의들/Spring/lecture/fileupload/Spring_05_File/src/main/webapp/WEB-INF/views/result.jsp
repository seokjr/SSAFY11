<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단일파일 업로드</title>
</head>
<body>
	<h2>단일 파일 업로드</h2>
	<a href="${pageContext.request.contextPath}/resources/upload/${fileName}">${filaName}</a>
	<img src="${pageContext.request.contextPath}/resources/upload/${fileName}">
	
	<a href="download?fileName=${fileName}">${fileName}다운로드</a>
	
</body>
</html>