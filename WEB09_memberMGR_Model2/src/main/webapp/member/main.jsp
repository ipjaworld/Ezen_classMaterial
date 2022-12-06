<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<script type="text/javascript">

</script>
</head>
<body>

<table>
	<tr><td>안녕하세요. ${loginUser.name}(${loginUser.userid})님</td></tr>
	<tr><td > email : ${loginUser.email}</td></tr>
	<tr><td > 전화번호 : ${loginUser.phone}</td></tr>
	<tr>
		<td >
			<input type="button" value="로그아웃" 	onclick="location.href='member.do?command=logout'">
			<input type="button" value="회원정보변경" onclick="location.href='member.do?command=updateForm'">
			<input type="button" value="회원탈퇴" onclick="deleteMember();">
		</td>
	</tr>
</table>

<br><br>
<c:if test="${loginUser.admin==1 }">
	<table align="left" width="800" bgcolor="black" cellspacing="1">
		<tr bgcolor="white">
			<th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>관리자/<br>일반회원</th><th>등급변경</th>
		</tr>
		<c:forEach var="member" items="${mList}">
			<tr align="center" bgcolor="white">
				<td>${member.userid }</td>
				<td>${member.name }</td>
				<td>${member.phone }</td>
				<td>${member.email }</td>
				<td><c:if test="${member.admin==1 }">관리자</c:if>
					<c:if test="${member.admin==0 }">일반회원</c:if></td>
			<td width="180">
				<c:if test="${loginUser.userid != member.userid }">
					<c:if test="${member.admin==0}">
						<input type="button" value="관리자로 변경"
						onclick="location.href='member.do?command=editAdmin&userid=${member.userid }'">
					</c:if>
					<c:if test="${member.admin==1}">
						<input type="button" value="일반회원으로 변경"
						onclick="location.href='member.do?command=editAdmin&userid=${member.userid }'">
					</c:if>
				</c:if></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>



