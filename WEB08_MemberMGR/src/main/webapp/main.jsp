<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<table>
	<tr><td>${loginUser.name}(${loginUser.userid})님 로그인하셨습니다.</td></tr>
	<tr><td> email : ${loginUser.email}</td></tr>
	<tr><td> 전화번호 : ${loginUser.phone}</td></tr>
	<tr><td><input type="button" value="로그아웃" onClick="location.href='logout.do'" />
		<input type="button" value="회원정보변경" onClick="location.href='update.do?userid=${loginuser.userid}'">
		<input type="button" value="회원 탈퇴" onClick="withDrawConfirm();">
		<!-- a(anchor) 태그를 제외한 어떤 태그이든 onClick 속성을 써서 페이지 이동을 하고자 한다면, 위와 같이 location.href를
		onClick 속성에 지정해서 이동합니다. onClick 속성에는 페이지 이동 기능이 없기 때문에 페이지만 쓴다고 이동하지 않으니 반드시
		location.href 로 페이지를 지정해주세요 -->
		</td></tr>
</table>

</body>
</html>