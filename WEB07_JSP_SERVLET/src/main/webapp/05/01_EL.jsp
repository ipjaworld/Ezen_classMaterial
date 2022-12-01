<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_EL.jsp</title>
</head>
<body>

<!-- 표현 언어(EL, Expression Language : JSP 의 전달값이나 변수값 등 자료를 출력할 때의 번거로움을
간단히 해결하기 위하여 만들어진 출력 문법, jsp 의 문법을 html5에서 좀 더 구분하기 쉽고,
오류를 줄여서 운용하기 위해 개발된 언어. 주로 pageContext, request, session, application 에 전달되는
Attribute의 값을 getter를 이용하지 않고 출력할 때 많이 사용합니다. -->

<h3>
JSP 문법 사용 1: <%="Hello" %><br>
JSP 문법 사용 2: <% out.println("hello"); %><br>
EL 문법 사용 : ${"Hello"} 
</h3>



<br><br>
<h3>
정수형 ${10}
실수형 ${5.6}<br>
문자열형 : ${"홍길동" }<br>
논리형 : ${true}<br>
null : ${null}<br>
</h3>


<br><br>
<h3>
<!-- 산술 연산 -->
10과 2의 합 : ${10+2 }<br>
<!-- 
\${10-2} 는 모양 그대로 출력,
${10-2}는 계산된 결과 출력
 -->
 \${ 10 - 2 } : ${10-2 }<br>
 \${ 10 * 2 } = ${10*2 }<br>
 \${ 10 / 2 } = ${10/2 }<br>
 \${ 10 % 3 } = ${10%3 }<br>
 \${ 10 mod 3 } = ${10 mod 3 }<br>
</h3>



<br><br>
<h3>
<!-- 관계 연산(비교 연산) -->
\${ 10 == 2 } = ${10 == 2 }<br>
\${ 10 eq 2 } = ${10 eq 2 }<br>
\${ 10 < 2 } = ${10 < 2 }<br>
\${ 10 lt 2 } = ${10 lt 2 }<br>
\${ 5 >= 4 } = ${5 >= 4 }<br>
\${ empty("") } = ${ empty("") }<br>
</h3>


<br><br>
<h3>
<%-- 문자열 연결(EL 3.0 추가) --%>
\${ "문자" += "열" += "연결" } = ${ "문자" += "열" += "연결" }<br>

</h3>


<!-- 서버 객체의 내용을 getAttribute 메서드 없이 사용 -->
<%
pageContext.setAttribute("name", "홍길서");
request.setAttribute("name", "홍길동");
session.setAttribute("name", "홍길남");
application.setAttribute("name", "홍길북");
%>

<h3>
JSP 문법 : <%=request.getAttribute("name") %><br>
JSP 문법 : 
	<% String str = (String) request.getAttribute("name"); %>
	<%=str %><br>
</h3>


<h3>
EL 문법 :${name}<br>
EL 문법 :${requestScope.name}<br>
EL 문법 :${sessionScope.name}<br>
EL 문법 :${applicationScope.name}<br>
</h3>

<!-- EL을 이용할 때 서버 객체의 내용을 출력하고자 할때, 어떤 객체인지 명시하지 않고, 애트리뷰터 이름만 사용한다면,
사용하려는 애트리뷰트가 있는 객체를 순서(pageContext -> request -> session -> application)
대로 검사하여 가장 먼저 발견된 내용이 출력됩니다.
name 이라는 애트리뷰트를 갖고 있는 객체 중에서 순서적으로 가장 우선인 객체 내용이 출력됩니다. -->




<br><br><br><br>
</body>
</html>