<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10_Format01.jsp</title>
</head>
<body>

<!-- 오늘 날짜 발생 및 변수에 저장 -->
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>

<!-- 일반적인 출력 -->
<h2>\${now } : ${now }</h2>

<!-- JSTL 포맷팅에 의한 출력 -->
<h2>
날짜포맷 일반 형식 : <fmt:formatDate value="${now}"></fmt:formatDate> <br>
날짜포맷 date : <fmt:formatDate value="${now}" type="date"></fmt:formatDate><br>
시간포맷 time : <fmt:formatDate value="${now}" type="time"></fmt:formatDate><br>
날짜 시간 동시에 both : <fmt:formatDate value="${now}" type="both" /><br>
</h2>


<br><br>
<h2>
default : <fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default" /><br>
short : <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
medium : <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" /><br>
long : <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" /><br>
full : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
</h2>


<h2>
pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" :
<fmt:formatDate value="${now}" pattern="yyyy 년 MM 월 dd 일 mm 분 ss초"/><br>
</h2>

</body>
</html>



