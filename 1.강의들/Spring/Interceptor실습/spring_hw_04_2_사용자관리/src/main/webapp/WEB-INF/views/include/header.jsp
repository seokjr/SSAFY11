<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.hw.model.dto.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<style>
label {
	display: inline-block;
	width: 80px;
}

#user-info {
	text-align: right;
}
</style>
<div id="user-info">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<%
	// session에서 user 객체 가져오기
	Object userObj = session.getAttribute("loginUser");
	// null 인지 검사후 User 로 타입 변환
	User user = userObj == null ? null : (User) userObj;
	// 로그인 정보가 없을 경우는 로그인을 위한 폼을 제공한다.
	if (userObj == null) {
	%>
	<%--로그인 폼 --%>
	<form method="post" action="login">
		<input type="text" name="id" placeholder="아이디"> 
		<input type="password" name="password" placeholder="비밀번호">
		<button>로그인</button>
	</form>
	<%
	}
	// 로그인 정보가 있는 경우는 사용자 이름과 로그아웃을 위한 링크를 생성한다.
	else {
	%>
	<div>
		<%--user에 설정한 이름 사용 --%>
		<%-- <%=user.getName()%> --%>
		<%=user.getName()%>
		님 반갑습니다. <a href="logout">로그아웃</a>
	</div>
	<%
	}
	%>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>