<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView.jsp</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript"></script>
</head>
<body>

<div id="wrap" align="center">
	<h1>게시글 상세보기</h1>
	<table>
		<tr>
			<th width="100">작성자</th><td width="330">${board.userid}</td>
			<th width="100">이메일</th><td>${board.email}</td>
		</tr>
		<tr>
			<th>작성일</th><td><fmt:formatDate value="${board.writedate }"/></td>
			<th>조회수</th><td>${board.readcount}</td>
		</tr>
		<tr>
			<th>제목</th><td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>내용</th><td colspan="3"><pre>${board.content}</pre></td>
		</tr>
	</table><br><br>
	<input type="button" value="리스트로" onclick="location.href = 'board.do?command=main'">
	<input type="button" value="수정" onclick="checkPass('${board.num}', 'update');">
	<input type="button" value="삭제" onclick="checkPass('${board.num}', 'delete');">

</div>

</body>
</html>