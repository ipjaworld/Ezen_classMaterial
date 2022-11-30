<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>084_useBeanAction.jsp</title>
</head>
<body>
<!--  리퀘스트에 담겨온 객체는 아래와 같이 꺼냅니다 -->
<jsp:useBean id="member" class="com.ezen.dto.MemberBean" scope="request"/>

<h2> 입력 완료된 회원 정보</h2>
<table>
	<tr><td>이름</td>
		<td><jsp:getProperty name="member" property="name" /></td></tr>
    <tr><td>아이디</td>
    	<td><%=member.getUserid() %></td></tr>
    <tr><td>별명</td>
    	<td><%=member.getNickname() %></td></tr>
    <tr><td>비밀번호</td>
    	<td><%=member.getPwd() %></td></tr>
    <tr><td>이메일</td>
    	<td><%=member.getEmail() %></td></tr>
    <tr><td>전화번호</td>
    	<td><%=member.getPhone() %></td></tr>
    <!-- jsp로 만든 객체를 액션태그로 접근하지 못하지만, 그 반대의 경우는 위와 같이 가능합니다. -->
</table>
</body>
</html>