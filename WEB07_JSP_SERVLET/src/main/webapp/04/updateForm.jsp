<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>

<%!
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";

String uid = "scott";
String pass = "tiger";

String sql = "select * from mem where id=?";
%>
</head>
<body>
<%

	String userid = request.getParameter("userid");
	String name = null, phone=null;
	// 해당 회원의 정보를 조회해서 이름과 전화번호를 해당 변수에 저장합니다.

	try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, pass);
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userid);
		
		rs = pstmt.executeQuery();
		
		if( rs.next() ){
			name = rs.getString("name");
			phone = rs.getString("phone");
		}
	}catch(Exception e){ e.printStackTrace();
	}finally{
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){ e.printStackTrace(); }
	}
%>
<h2>회원의 정보 수정 폼</h2>
<form method="post" action="updateMember_do.jsp">
	<table width="550" border="1">
	<tr><td>이름</td><td><input type="text" name="name" size="20" value="<%=name %>"/></tr>
	<tr><td>아이디</td><td><%=userid %><input type="hidden" name="userid" value="<%=userid%>"></td></tr>
	<tr><td>비밀번호</td><td><input type="password" name="pwd" size="20"/></tr>
	<tr><td>전화번호</td><td><input type="text" name="phone" size="11" value="<%=phone %>"/></tr>
	<tr><td colspan="2"><input type="submit" value="정보수정"></td><td><input type="reset" value="취소"></td></tr>
	</table>
</form>
<!-- form 과 테이블을 제작하여 수정할 내용을 입력란에 표시하되, 아이디는 수정하지 못하게 합니다
비밀번호는 빈칸, 나머지 이름과 전화번호란에 해당 변수에 있는 값을 value 값으로 넣어주세요 -->

<a href="MemberMGR.jsp">돌아가기</a>
</body>
</html>




