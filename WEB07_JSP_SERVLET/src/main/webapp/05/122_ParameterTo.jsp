<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>122_ParameterTo.jsp</title>
</head>
<body>

당신이 입력한 정보입니다.(고전적인 방식).<hr>
아이디: <%=request.getParameter("id") %> <br>
비밀번호: <%=request.getParameter("pwd") %> <br> <br>

당신이 입력한 정보입니다.(EL 방식).<hr>
아이디: ${param.id}<br>
비밀번호: ${param["pwd"]}

</body>
</html>