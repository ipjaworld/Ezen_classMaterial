<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_ForEach.jsp</title>
</head>
<body>

<%
	String [] movieList = {"타이타닉", "시네마 천국", "혹성 탈출", "킹콩"};
	request.setAttribute("mList", movieList);
	// Attribute 는 해쉬맵 형식의 리스트이므로 키값만 존재하면 어떤 자료들도 보관할 수 있습니다.
	// ArrayList 등도 위의 배열과 같이 손쉽게 보관하거나 전달할 수 있습니다.
%>

<!-- 저장되었던 배열을 jsp 문법으로 꺼내서 출력한다면 -->
<%
	String [] mlist = (String [])request.getAttribute("mList");
	for( String s : mlist )
		out.print(s+"<br>");
%>
<br><br>


<!-- EL과 jstl 을 이용한 반복 실행문 - 배열의 요소를 이용합니다. -->
<c:forEach items="${mList}" var="movie">
	${movie}<br>
</c:forEach>


</body>
</html>


