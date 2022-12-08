<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateMemberForm.jsp</title>
<script src="script/board.js"></script>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
<div id="wrap" align="center">
	<h1>사용자 수정</h1>
	<form name="frm" method="post" action="board.do">
		<input type="hidden" name="command" value="updateMember">
		<table>
			<tr><th>아이디</th><td>${loginUser.userid}
				<input type="hidden" name="userid" value="${loginUser.userid}"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pwd" size="20">*</td></tr>
			<tr><th>비번확인</th><td><input type="password" name="pwd_check" size="20">*</td></tr>
			<tr><th>이름</th><td><input type="text" name="name" size="20" value="${loginUser.name}">*</td></tr>
			<tr><th>전화번호</th><td><input type="text" name="name" size="20" value="${loginUser.name}">*</td></tr>
			<tr><th>이메일</th><td><input type="text" name="name" size="20" value="${loginUser.name}">*</td></tr>
			<tr><th>등급</th><td><input type="text" name="name" size="20" value="${loginUser.name}">*
				<c:choose>
					<c:when test="${loginUser.admin==0}">
						<input type="radio" name="admin" value="0" checked="checked">일반회원
						<input type="radio" name="admin" value="1">관리자
					</c:when>
					<c:otherwise>
						<input type="radio" name="admin" value="0">일반회원
						<input type="radio" name="admin" value="1" checked="checked">관리자
					</c:otherwise>
				</c:choose></td></tr>
		</table> <br><br>
		<input type="submit" value="수정" onClick="return updateMemberCheck();">
		<input type="reset" value="다시 작성"><input type="button" value="목록으로"
			onClick="location.href='board.do?command=main'">
	</form>
</div>


</body>
</html>