<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>

<div id="wrap" align="center">
<h1>게시글 리스트</h1>
	<table>
		<tr>
			<td colspan="5" style="border:white;">
				<div style="float:left;">${loginUser.name}(${loginUser.userid})님 로그인 
					<input type="button" value="정보수정" onClick="location.href='board.do?command=updateMemberForm'"/>
					<input type="button" value="로그아웃" onClick="location.href='board.do?command=logout'">
				</div>
				<div style="float:right;">
					<a href="board.do?command=boardWriteForm">게시글 등록</a></div>
			</td>
		</tr>
		
		
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th></tr>
		<c:forEach items="${bList}" var="board">
			<tr align="center">
				<td width="100">${board.num}</td>
				<td align="left">
					&nbsp;<a href="board.do?command=boardView&num=${board.num}">${board.title}</a>
					<c:if test="${board.replycnt>0}">
						<span style="color:red;font-weight:bold;">[${board.replycnt}]</span>
					</c:if>
				</td>
				<td width="100">${board.userid}</td>
				<td width="200"><fmt:formatDate value="${board.writedate}"/></td>
				<td width="100">${board.readcount}</td>
			</tr>
		</c:forEach>
		
	</table><br><br>
	
	<!-- 여기서부터 페이지 표시 -->
	<div id="paging" style="margin:0 auto; font-size:110%; font-weight:bold">
		
		<!-- 페이지가 클릭될때마다 이동할 링크 기본경로를 JSTL변수에 저장 -->
		<c:url var="action" value="board.do?command=main" />
		
		<!-- prev표시 : 전달된 paging 의 prev 변수가 true 이면 표시, false이면 표시하지 않음 -->
		<c:if test="${paging.prev}" >
			<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
			<!-- 링크되는 주소 : board.do?command=main&page=?? -->
			<!-- paging.beginPage-1 : 맨 왼쪽 페이지(beginPage) 보다 1페이지 작은 페이지로 이동 -->
		</c:if>
		
		
		<!-- beginPage 부터 endPage 값까지 페이지 표시 & 해당페이지에 링크 -->
		<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
			<c:choose>
				<c:when test="${index==paging.page}">
					<span style="color:red">${index}&nbsp;</span>
				</c:when>
				<c:otherwise>
					<a href="${action}&page=${index}">${index}&nbsp;</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<!-- next표시 : 전달된 paging 의 next 변수가 true 이면 표시, false이면 표시하지 않음 -->
		<c:if test="${paging.next}">
			<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
			<!-- 맨 오른쪽 페이지(endPage) 보다 1페이지 큰 페이지로 이동 -->
		</c:if>
	</div>	
</div>
</body>
</html>














