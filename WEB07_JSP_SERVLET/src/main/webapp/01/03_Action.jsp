<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_Action.jsp</title>
</head>
<body>

<form name="joinForm" action="03_Action_to.jsp" method="get">
	<!-- 
		name : 스크립트에서 다른 것들과 구분하여 명명하기 위한 이름으로 사용, id가 css 에서 구분하기 위한 이름이었다면
				name은 주로 DOM에서 구분하기 위한 이름이라고 보면 됩니다.
		action : 입력란 선택란에 입력하고 선택한 내용이 서버에 전달되고, 페이지가 이동할 대상 파일
		method : 전달 방식을 의미하며, get 은 일반전송방식, post는 비공개 전달 방식 사용	
	-->
	<label for="name">이름</label><span style="color:red;">*</span>
	<input type="text" id="name" name="name" value=""> <br>
	<label for="id">아이디</label><span style="color:red;">*</span>
	<input type="text" id="id" name="id" value=""><br>
	<label for="pwd">비밀번호</label><span style="color:red;">*</span>
	<input type="password" id="pwd" name="pwd" value=""> <br>
	<label for="pwd_re"> 비밀번호 확인</label><span style="color:red;">*</span>
	<input type="password" id="pwd_re" name="pwd_re" value=""><br>
	<input type="submit" value="회원가입">
	<input type="reset" value="다시작성">
</form>
<br><br><br>
<a href="03_Action_to.jsp?useritem=ABCDEFG">전송하려면 클릭하세요</a>
</body>
</html>