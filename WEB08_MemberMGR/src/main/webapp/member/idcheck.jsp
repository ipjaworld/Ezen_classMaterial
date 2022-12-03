<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck.jsp</title>
<script type="text/javascript">
	function idok( p_id ){
		opener.document.frm.userid.value= p_id;
		opener.document.frm.reid.value= p_id;
		// 중복 체크 완료의 의미로 userid 입력란과 reid 입력란의 값을 전달된 아이디로 맞춥니다
		self.close();
	}
</script>
</head>
<body>
<c:choose>
	<c:when test="${result==1}">
		${userid}는 이미 사용중인 아이디 입니다.
		<script type="text/javascript">
			opener.document.frm.userid.value='';
			opener.document.frm.reid.value='';
			// 팝업창을 오픈한 주체 : opener
		</script>
	</c:when>
	<c:otherwise>
		${userid}는 사용 가능한 아이디입니다.
		<input type="button" value="사용할께요" onClick="idok('${userid}');">
	</c:otherwise>
</c:choose>
<br><br>

<!-- 첫번째 체크한 아이디 말고 다른 아이디를 체크하기 위한 폼 -->
<form action="idcheck.do" method="get" name="frm">
	아이디 : <input type="text" name="userid" value="${userid }">
	<input type="submit" value="중복 체크">
</form>
<!-- 최초 팝업창을 열었을 때 호출된 서블릿처럼 "idcheck.do?userid=" + inputid
	새로운 아이디로 다시 검색하는 폼입니다. 해당 아이디로 중복 체크 후 idcheck.jsp 파일 이곳으로
	다시 되돌아와서 사용가능 여부와 재검색을 또 다시 할 수 있습니다. -->

</body>
</html>