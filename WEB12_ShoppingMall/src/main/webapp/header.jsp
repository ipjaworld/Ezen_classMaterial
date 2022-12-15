<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<link href="css/shopping.css" rel="stylesheet">
<script src="member/member.js"></script>
<script src="mypage/mypage.js"></script>
</head>
<body>

<div id="wrap">
	<header> <!-- 로고, 주상단 메뉴, 카테고리 메뉴가 표시되는 영역 -->
	
		<div id="logo">
			<a href="shop.do?command=index">
				<img src="images/logo.png" width="180" height="100">
			</a>
		</div> <!-- 로고 끝 -->
		
		<nav id="top_menu"> <!-- 메인메뉴 시작 -->
			<ul>
				<c:choose>
					<c:when test="${empty loginUser}">
						<li><a href="shop.do?command=loginForm">LOGIN</a></li>
						<li><a href="shop.do?command=contract">JOIN</a></li>
					</c:when>
					<c:otherwise>
						<li>${loginUser.name}(${loginUser.id})</li>
						<li><a href="#">정보수정</a></li>
						<li><a href="shop.do?command=logout">LOGOUT</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="#">CART</a></li>
				<li><a href="#">MY PAGE</a></li>
				<li><a href="#">Q &amp; A</a></li>

			</ul>
		</nav> <!-- 메인 메뉴 끝 -->
		
		<nav id="category_menu"> <!-- 카테고리 메뉴 시작 Heels Boots Sandals .. 등등 -->
		
			<ul>
				<li><a href="#">Heels</a></li>
				<li><a href="#">Boots</a></li>
				<li><a href="#">Sandals</a></li>
				<li><a href="#">Sneakers</a></li>
				<li><a href="#">Sleeper</a></li>
				<li><a href="#">On Sale</a></li>
			</ul>
		
		</nav> <!-- 카테고리 메뉴 끝 -->
		
	</header>



