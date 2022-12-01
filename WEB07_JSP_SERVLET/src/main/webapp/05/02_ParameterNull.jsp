<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_ParameterNull.jsp</title>
</head>
<body>

<h3>JSP 코드 : <%=request.getParameter("id") %></h3>
<h3>EL 코드 : ${ param.id }</h3>

<%--
<%
	if( request.getParameter("id").equals("hong")){	// null 과 비교하는 equals 메서드는 무조건 에러입니다.
		out.print("홍길동님 안녕하세요");
	}
%>
 --%>
<br><br>
JSP 코드
request.getParameter("id").equals("hong") -> 에러<br>
equals() 사용 결과 : error - equals 메서드는 "null 값" 으로 비교할 때 오류를 발생시킴

<br><br>
에러를 방지하기 위해 아래와 같은 연산을 사용 : <br>
request.getParameter("id")!=null && request.getParameter("id").equals("hong")


<br><br>
<hr>
EL 식
'==' 연산자 사용 결과 : \${param.id=="hong" } -> ${param.id=="hong" }


 
 
 
</body>
</html>