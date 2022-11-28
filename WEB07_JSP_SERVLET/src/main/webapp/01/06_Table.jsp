<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_Table.jsp</title>
</head>
<body>
	<h1>JSP로 만든 테이블</h1>
	<table cellspacing="1" bgcolor="blcak" width="500">
	<%
	int i = 1;
	int j = 1;
	%>
	<%
	for(i = 1; i<=5; i++){
	%>
		<tr tr bgcolor="white" height="80">
	<%
		for(j = 1; j<=5; j++){
	%>
			<td><%=i %>행 <%=j %> 열</td>
	<%
		}
	%>
		</tr>
	<%
	}
	%>
	</table>
	



	<h1>HTML5로만 만든 테이블</h1>
	<table cellspacing="1" bgcolor="black" width="500">
		<tr tr bgcolor="white" height="80">
			<td>1행 1열</td>
			<td>1행 2열</td>
			<td>1행 3열</td>
			<td>1행 4열</td>
			<td>1행 5열</td>
		</tr>
		<tr tr bgcolor="white" height="80">
			<td>2행 1열</td>
			<td>2행 2열</td>
			<td>2행 3열</td>
			<td>2행 4열</td>
			<td>2행 5열</td>
		</tr>
		<tr tr bgcolor="white" height="80">
			<td>3행 1열</td>
			<td>3행 2열</td>
			<td>3행 3열</td>
			<td>3행 4열</td>
			<td>3행 5열</td>
		</tr>
		<tr tr bgcolor="white" height="80">
			<td>4행 1열</td>
			<td>4행 2열</td>
			<td>4행 3열</td>
			<td>4행 4열</td>
			<td>4행 5열</td>
		</tr>
		<tr tr bgcolor="white" height="80">
			<td>5행 1열</td>
			<td>5행 2열</td>
			<td>5행 3열</td>
			<td>5행 4열</td>
			<td>5행 5열</td>
		</tr>
	</table>
</body>
</html>