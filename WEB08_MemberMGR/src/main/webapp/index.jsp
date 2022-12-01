<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>

<% 
// response.sendRedirect("loginForm.jsp");
response.sendRedirect("login.do");
// 서블릿을 거쳐서 포워딩된 페이지는 외부로 노출되지 않습니다.
%>
</body>
</html>