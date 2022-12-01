<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<table>
	<tr><td>${loginUser.name}(${loginUser.userid})님 로그인하셨습니다.</td></tr>
	<tr><td> email : ${loginUser.email}</td></tr>
	<tr><td> 전화번호 : ${loginUser.phone}</td></tr>
</table>

</body>
</html>