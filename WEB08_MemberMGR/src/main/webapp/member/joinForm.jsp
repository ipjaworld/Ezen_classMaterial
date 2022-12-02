<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm.jsp</title>
<script type="text/javascript">
	function idCheck(){
		if( document.frm.userid.value=="" ){
			alert("아이디를 먼저 입력하고 중복체크 버튼을 클릭하세요");
			document.frm.userid.focus();
			return;
		}
		
		var inputid = document.frm.userid.value;	// 중복체크하고자 하는 아이디 저장
		var opt = 'toolbar=no, menubar=no, scrollbars=yes, width=500, height=200';
		
		window.open( "idcheck.do?userid=" + inputid , 'idCheck' , opt );
		// 서블릿을 호출하고 포워딩된 페이지가 팝업창에 열릴 예정입니다.
		// 그래서 첫번째 요소는 서블릿의 urlmapping 이름을 씁니다
		// 서블릿 호출시 파라미터를 위와 같이 호출되는 주소 뒤에 ? 함께 전달할 수 있습니다.
	}
</script>
</head>
<body>
	<h2>회원 가입</h2> '*' 표시 항목은 필수 입력 항목입니다.
	<form action="join.do" method="post" name="frm">
		<table>
			<tr><td>이름</td><td><input type="text" name="name" size="20">&nbsp;*</td></tr>
		    <tr><td>아이디</td><td><input type="text" name="userid" size="20">&nbsp;*
		        <input type="button" value="중복 체크" onClick="idCheck();" />
		        <input type="hidden" name="reid" value=""></td>
		        <!-- reid 태그 : 아이디 중복 체크 후 사용가능한 아이디라면 사용할 아이디를 reid 태그의 value 값으로 저장합니다
		        그리고 나중에 현재 아이디가 입력된 userid와 reid 값이 같은 값인지 보고 중복 체크 여부를 체크합니다 -->
		    </tr>
		    <tr><td>비밀번호</td><td><input type="password" name="pwd" size="20" />&nbsp;</td></tr>
		    <tr><td>비밀번호 확인</td>
		        <td><input type="password" name="pwd_check" size="20" />&nbsp;</td></tr>
		    <tr><td>이메일</td><td><input type="text" name="email" size="20"></td></tr>
		    <tr><td>전화번호</td><td><input type="text" name="phone" size="20"></td></tr>
		    <tr><td>등급</td><td><input type="radio" name="admin" value="0" checked="checked">
		        일반회원&nbsp;<input type="radio" name="admin" value="1">관리자</td></tr> 
		    <tr><td colspan="2" align="center">
		        <input type="submit" value="회원 가입" onClick="return joinCheck()" />
		        <input type="reset" value="취소">
		    </td></tr>
		</table>
	</form>
</body>
</html>