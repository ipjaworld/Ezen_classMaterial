<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_Sum.jsp</title>
</head>
<body>
	<!-- JSP는 JAVA 에서 사용하던 거의 모든 문법이 똑같이 사용됩니다. -->
	<% 
		int sum = 0;
		for( int i = 1; i<=100; i++){
			sum+=i;
		}
	%>
	<h2>1부터 100까지의 함계 : <%= sum %></h2>
	<% 
		sum = 0;
		for( int i = 1; i<=1000; i++){
			sum+=i;
		}
	%>
	<h2>1부터 1000까지의 합계 : <%= sum %></h2>
	
	<!-- JSP 명령들 사이에 HTML 같은 요소들이 껴들어야 한다면 JSP 영역을 끝내고 해당 내용을
		기술한 후 다시 JSP 영역을 시작시킵니다.
		한 페이지안에서 JSP 명령은 중간에 영역이 끝나고 다시 시작해도 한 프로그램처럼 이어집니다-->
</body>
</html>