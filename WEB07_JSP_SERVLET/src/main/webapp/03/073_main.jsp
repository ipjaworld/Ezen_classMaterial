<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>073_main.jsp</title>
</head>
<body>
<%
	if( session.getAttribute("loginUser") == null ){
		response.sendRedirect("071_LoginForm.jsp");	// 로그인창으로 되돌아갑니다.
	}else{
%>
	로그인 관리자 <br> 전화번호 010-123-1234
	<h2><%=session.getAttribute("loginUser") %> 님이 로그인하셨습니다</h2>
	저희사이트에 방문해주셔서 감사합니다.<br> 즐거운 시간 되세요...<br>
	
	<form method="get" action="074_logout_do.jsp">
		<input type=submit value="로그아웃">
		<!-- 074_logout_do.jsp 에서 로그인 정보에 해당하는 세션값을 지우고 로그인 창으로 이동하게 코딩해주세요 -->
	</form>
	
	
<%
	}
%>
</body>
</html>