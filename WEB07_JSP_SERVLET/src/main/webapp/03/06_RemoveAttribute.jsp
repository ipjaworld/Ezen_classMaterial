<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_RemoveAttribute.jsp</title>
</head>
<body>

<%
	session.setAttribute("s_name1", "저는 세션에 저장된 첫번째값이에요. ^o^");
	session.setAttribute("s_name2", "저는 세션에 저장된 두번째값이에요. ^o^");
	session.setAttribute("s_name3", "저는 세션에 저장된 세번째값이에요. ^o^");
	
	out.print("<h3> >> 세션값을 삭제하기 전 << </h3>");
	out.print("s_name1 : " + session.getAttribute("s_name1") + "<br>");
	out.print("s_name2 : " + session.getAttribute("s_name2") + "<br>");
	out.print("s_name3 : " + session.getAttribute("s_name3") + "<br>");
	
	session.removeAttribute("s_name2");	//이름을 지정하여 세션에 저장된 객체를 제거합니다.
	
	out.print("<hr><h3> >> 세션값을 삭제한 후 << </h3>");
	out.print("s_name1 : " + session.getAttribute("s_name1") + "<br>");
	out.print("s_name2 : " + session.getAttribute("s_name2") + "<br>");
	out.print("s_name3 : " + session.getAttribute("s_name3") + "<br>");
	
	session.invalidate();
	out.print("<hr><h3> >> 세션값을 모두 삭제한 후 << </h3>");
	/* 모든 세션이 삭제되어 null 값 출력도 불가능합니다. */
	//out.print("s_name1 : " + session.getAttribute("s_name1") + "<br>");
	//out.print("s_name2 : " + session.getAttribute("s_name2") + "<br>");
	//out.print("s_name3 : " + session.getAttribute("s_name3") + "<br>");
%>
</body>
</html>