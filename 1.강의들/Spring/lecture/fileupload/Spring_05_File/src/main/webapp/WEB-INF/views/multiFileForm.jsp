<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다중파일업로드</title>
</head>
<body>
	<h2>다중파일 업로드</h2>
	<form action="multiFileUpload" method="POST" enctype="multipart/form-data">
		<input type="file" name="files" multiple="multiple">
		<input type="submit" value="파일등록">
	</form>
</body>
</html>