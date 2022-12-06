<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>

<body>

<div id="wrap" align="center">
<h1>게시글 리스트</h1>
	<table>
		<tr>
			<td colspan="5" style="border:white;">
				<div style="float:left;">${loginUser.name}(${loginUser.userid})님 로그인
					<input type="button" value="정보수정" onClick="location.href='board.do?command=updateMemberForm'" />
					<input type="button" value="로그아웃" onClick="location.href='board.do?command=logout'" />
				</div>
				<div style="float:right;">
					<a href="board.do?command=boardWriteForm">게시글 등록</a>
				</div>
		</tr>
		
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th></tr>
		<c:forEach items="${bList}" var="board">
			<tr align="center">
				<td width="100">${board.num}</td>
				<td align="left">
					&nbsp;<a href="board.do?command=boardView&num=${board.num}"> ${board.title}</a>
				</td>
				<td width="100">${board.userid}</td>
				<td width="100">${board.num}</td>
				<td width="100">${board.num}</td>
			</tr>
		</c:forEach>
		
	</table><br><br>

</div>

</body>
</html>