<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_Select.jsp</title>
</head>
<body>
	<form method="get" action="05_Select_to.jsp">
		<label for="job">직업</label><br>
		<select id="job" name="job" size="1">
			<option value=""></option>
			<option value="학생">학생</option>
			<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
			<option value="언론">언론</option>
			<option value="공무원">공무원</option>
			<option value="군인">군인</option>
			<option value="서비스업">서비스업</option>
		</select><br><br><br>
		<label for="interest" style="float: left;">관심분야</label><br>
		<select id="interest" name="interest" size='5' multiple="multiple">
			<option value="에스프레소">에스프레소</option>
			<option value="로스팅">로스팅</option>
			<option value="생두">생두</option>
			<option value="원두">원두</option>
			<option value="핸드드립">핸드드립</option>
		</select><br><br>
		<input type="hidden" name="userItem" value="ABCDEF">
		<!-- <input type="text">를 쓰지 않고 보내고자 하는 정보는 hidden을 이용합니다. -->
		<input type="submit" value="전송">
	</form>
</body>
</html>