<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_Action_to.jsp</title>
</head>
<body>

<h3>get 방식으로 요청되어진 주소</h3>
<h3>http://localhost:8090/WEB07_JSP_SERVLET/01/03_Action_to.jsp?
	name=hong+gil+dong&id=hong&pwd=1234&pwd_re=1234</h3>

<h3> post 방식으로 요청되어진 주소 </h3>
<h3>http://localhost:8090/WEB07_JSP_SERVLET/01/03_Action_to.jsp</h3>	

<!-- 03_Action_to.jsp 는 최종 이동할 페이지 이름이며, 그뒤 ? 이후의 내용은 name = value 로 구성되어 서버로
	전송된 입력 데이터 들입니다. post 방식은 이들을 노출하지 않습니다 -->
<!-- 주소 내에 포함된 value 중 한글은 인코딩 방식에 따라 %16진수값으로 표시될 수 있습니다. -->

<!-- 03_Action.jsp 에서 출발한 폼데이터들은 주소에 섞여서 action 에 써놓은 페이지에 도착한거 같지만,
	주소는 주소일뿐 입력란에 입력된 데이터들은 모두 서버에 저장됩니다. 
	name 으로 구분된 value 값들 모두
	그리고 요청주소에 포함되어 표시될뿐 주소에 있는 값들을 앞으로 이용하는것은 아니고 서버에 있는 데이터를 불러서 이용합니다. -->

	<!-- 아래는 서버에 저장되어 불려져오는 구문과 내용들입니다 -->
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String pwd_re = request.getParameter("pwd_re");
	
	String userItem = request.getParameter("useritem");
	// getParameter로 받는 모든 데이터는 String 데이터로 받을 수 있습니다.
	// 만약 위 항목 중 입력 란이 비어있거나 name 값이 없는게 존재한다면 String 변수는 null이 됩니다.
%>
<h3>
성명 : <%=name %><br>
아이디 : <%=id %><br>
비밀번호 : <%=pwd %><br>
비밀번호 확인 : <%=pwd_re %><br>
</h3>
<h1>UserItem : <%=userItem %></h1>
</body>
</html>