<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_Checkbox_to.jsp</title>
</head>
<body>

<% 
	String [] item = request.getParameterValues("item");
%>

<% 
	if( item == null ){
%>
	<h3>선택한 항목이 없습니다</h3>
<% 
	}else{
%>
	<h3> 당신이 선택한 항목입니다 </h3>
<% 
		for( String it : item ) {
%>
		<h3><%=it %></h3>
<%
		}
	}
%>
	

</body>
</html>