<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardCheckPass.jsp</title>
</head>
<body>
<div align="center">
	<h1>비밀번호 확인</h1>
	<form action="board.do" method="post" name="frm">
		<input type="hidden" name="command" value="boardCheckPass">
		<input type="hidden" name="num" value="${param.num}"><!-- 현재 게시물의 게시물 번호 -->
		
		<table style="width:80%">
			<tr><th>수정/삭제 비밀번호</th>
				<td><input type="password" name="pass" size="20"></td></tr>
		</table><br>
		<input type="submit" value="확  인" onclick="return passCheck()">
		<br><br>${message}
	</form>
	<!-- submit 을 누르면 hidden으로 숨어있는 현재 게시물의 게시물 번호와 사용자가 수정 삭제하고자 입력한
		비밀 번호를 갖고 비교하려 command=boardCheckPass 로 이동합니다.
		비밀번호가 게시물 비밀번호와 일치하면 수정하러 이동, 틀리면 현재 페이지로 다시 복귀 - 이때 '비밀번호'가 
		맞지 않습니다' 라는 메세지를 함께 갖고 돌아옵니다. -->
</div>

</body>
</html>