<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>안녕하세요</h2>
<h2>JAVA SERVER PAGE(JSP)</h2>

<!-- JSP는 JAVA SERVER PAGE의 약자로 웹페이지 내부에 프로그래밍적인 요소를 추가하거나,
서버에서 계산되고 실행된 결과를 웹페이지에서 표시하고자 할 때 사용합니다. 쉽게 얘기한다면, 웹페이지 HTML5 중간 중간에
자바 프로그래밍 코드를 좀 같이 쓰겠습니다 라는 뜻과 비슷합니다.
 -->
 
 사용 예는 아래와 같습니다. (날짜 변수 d의 선언과 객체 초기화 동작)-->
 <% java.util.Date d = new java.util.Date(); %>

<!-- HTML 로 페이지를 구성하던 중, JSP 에의한 컨텐츠가 중간에 나와야 한다면 필요한 곳에 JSP 명령을 씁니다. -->
<%-- 현재 jsp 파일안에 html 문법 사이로 jsp 문법이 껴들어 코딩될 때는 <% %>를 사용합니다. --%>

<!-- HTML5 주석 -->
<%-- 주석 내용 중에 <% %> 이 섞여있을 때의 주석 --%>



<h2>현재 시간 : <%=d%></h2>
<h2>현재 시간 : <%=new java.util.Date() %></h2>
<%-- 다만 페이지에 출력될 내용을 기술한다면 <% = %>를 쓰고 변수명이나 출력할 내용을 씁니다 --%>

<%-- <% jsp 명령 %> : 명령의 실행 --%>
<%-- <%= 변수 또는 출력 내용 %> : 웹페이지의 현재 위치에 출력 --%>


<!-- jsp 명령은 html 태그와 함께 파일로 저장되어 서버에 보관됩니다. 클라이언트의 요청을 받으면 해당 파일(~.jsp) 이
클라이언트로 전송되어 웹브라우저에 표시가 되게 되는데, 그 전에 jsp 명령은 이미 실행되어서 결과만 html 태그와 같이 전송
되어 집니다 -->

</body>
</html>