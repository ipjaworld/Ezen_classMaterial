<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_getSession.jsp</title>
</head>
<body>

<h3>세션에 저장된 값 하나씩 추출</h3>
<%
String id = (String) session.getAttribute("id");
String pwd = (String) session.getAttribute("pwd");
Integer age = (Integer) session.getAttribute("age");
// Attribute 에 저장되었던 모든 자료는 getAtrribute 로 꺼냈을 때 Object 형이므로, 원래의 자료형으로 사용하기 위해서는
// (자료형) 같은 형변환이 필요합니다.
%>
id : <%=id %><br>
pwd : <%=pwd %><br>
age : <%=age %><br>

<%
// 세션의 저장된 키값들만 얻어서 저장합니다
java.util.Enumeration<String> names = session.getAttributeNames();

while( names.hasMoreElements() ){
	// nextElement 를 String 형 변수에 저장
	String name = names.nextElement().toString();	//(String) 형변환을 사용하지 않고, 형변환 메서드를 사용
	// 얻어낸 키(name) 값으로 세션에서 getAttribute 로 value 값을 추출합니다.
	String value = session.getAttribute(name).toString();	//(String) 형변환을 사용하지 않고, 형변환 메서드를 사용
	out.println(name + " : " + value + "<br>");
}
%>



</body>
</html>