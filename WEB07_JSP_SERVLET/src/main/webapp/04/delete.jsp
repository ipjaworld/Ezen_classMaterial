<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete.jsp</title>
<% 
	String userid = request.getParameter("userid");
%>
<script>
const result = confirm("정말로 혼또니 레알로 계정을 삭제하는 것이 맞습니까?");
if(result){
	alert("삭제가 완료되었습니다.")
	location.href="delete_do.jsp?userid=<%=userid%>";
}else{
	alert("삭제가 취소되었습니다.")
	location.href="MemberMGR.jsp"
}

</script>
</head>
<body>

</body>
</html>