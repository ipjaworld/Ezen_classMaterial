<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productView.jsp</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
</head>
<body>
<div id="wrap" align="center">
	<h1>상품 상세 - 관리자 페이지</h1>
	<table>
		<tr> <!-- 1행짜리 테이블 입니다. 1열에는 이미지를 2열에는 상품정보 테이블을 배치합니다 -->
				<td width="220">
						<%-- <img src="upload/${product.pictureurl}"  width="200"> --%>
						<c:choose>
							<c:when test="${empty product.pictureurl}">
								<img src="upload/noname.jpg" width="220"height="300"></c:when>
							<c:otherwise>
								<img src="upload/${product.pictureurl}" width="220" height="300">
							</c:otherwise>
						</c:choose>
				</td>
				<td>
						<table>
								<tr><th width="80">상 품 명</th><td>${product.name}</td></tr>
								<tr><th>가 격</th><td>${product.price}원</td></tr>
								<tr><th>설 명</th><td><div style="height:220px; width:100%">
									<pre>${product.description}</pre></div></td></tr>
						</table>
				</td>
		</tr>
	</table>
	<input type="button" value="목록"	onclick="location.href='product.do?command=index'">
</div>
</body>
</html>