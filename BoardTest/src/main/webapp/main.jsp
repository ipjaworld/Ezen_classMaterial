<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2_Board</title>
<link rel="stylesheet" type="text/css" href="CSS/board.css">
</head>
<body>

<div id="wrap" align="center">
	<h1>게시글 리스트</h1>
	<table class="list">
		<tr>
			<td colspan="5" style="border: white; text-align: right">
				&nbsp;
			</td>
		</tr>
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>	<th>조회</th></tr>
		<c:forEach var="board" items="${boardList }">
			<tr class="record" align="center"><td>${board.num}</td>
				<td align="left">
				<a href="#">
					${board.title}
				</a>
				</td>
				<td>${board.name}</td>
				<td><fmt:formatDate value="${board.writedate }" /></td>
				<td>${board.readcount}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
</div><div class="clear"></div>

<jsp:include page="/paging/paging.jsp">
	<jsp:param value="board.do?command=boardList" name="command"/>
</jsp:include> 


</body>
</html>