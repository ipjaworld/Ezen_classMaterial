<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>083_ServerObject_Life.jsp</title>
</head>
<body>
<!-- 
* 각 객체의 수명 
pageContext : 현재 페이지까지
request : 다음 페이지까지 - forward에 의해 연장될 수 있습니다
session : 브라우져가 닫힐때까지
application : 서버가 꺼지거나 리셋될때까지
-->
<h1>
third의 pageContext 속성 : <%=pageContext.getAttribute("name") %> <br>
third의 request 속성 : <%=request.getAttribute("name") %> <br>
third의 session 속성 : <%=session.getAttribute("name") %> <br>
third의 application 속성 : <%=application.getAttribute("name") %> <br>
</h1>

</body>
</html>