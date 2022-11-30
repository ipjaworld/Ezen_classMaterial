<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	alert("로그 아웃 되었습니다.")
	location.href="071_LoginForm.jsp"
</script>
<%
    session.invalidate();
    //response.sendRedirect("071_LoginForm.jsp");	// 로그인창으로 되돌아갑니다.
%>