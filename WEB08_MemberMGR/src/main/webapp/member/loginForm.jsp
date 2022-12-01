<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function loginCheck(){
		if( document.frm.userid.value==""){
			alert("아이디는 필수 입력사항입니다.");
			document.frm.userid.focus();
			return false;
		}
		if( document.frm.pwd.value==""){
			alert("패스워드를 입력하세요");
			document.frm.pwd.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>

<form action="login.do" method="post" name="frm">
	<table>
		<tr><td>아이디</td><td><input type="text" name="userid"></td></tr>
		<tr><td>암 호</td><td><input type="password" name="pwd"></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="로그인" onClick="return loginCheck()">
			<!-- loginCheck() 함수의 리턴 값을 다시 form에 리턴해줌으로써 폼의 동작이 action 에 지정한 곳으로
			계속 이동을 진행할지 아니면 멈출지를 결정합니다. -->
			<input type="reset" value="취소">
			<input type="button" value="회원가입" onClick=""></td></tr>
			<tr><td colspan="2">${message }</td></tr>
	</table>
</form>

</body>
</html>