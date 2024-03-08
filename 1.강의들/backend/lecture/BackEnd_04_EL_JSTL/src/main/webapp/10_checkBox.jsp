<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬고르기</title>
</head>
<body>
	<h2>반찬을 골라보자</h2>
	<form action="10_checkBoxResult.jsp">
		<input type="checkbox" name = "dish" value="감자채볶음">감자채볶음
		<input type="checkbox" name = "dish" value="오징어젓갈">오징어젓갈
		<input type="checkbox" name = "dish" value="장조림">장조림 <br>
		<input type="checkbox" name = "dish" value="고순조">고순조
		<input type="checkbox" name = "dish" value="쏘야">쏘야
		<input type="checkbox" name = "dish" value="해빔소">해빔소
		<button>구매</button>
	</form>
</body>
</html>