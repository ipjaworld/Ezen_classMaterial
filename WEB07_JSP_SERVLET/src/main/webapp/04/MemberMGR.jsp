<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberMGR.jsp</title>
<%! 
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	
	String sql = "select * from mem";
%>
</head>
<body>
<!-- mem 테이블의 레코드를 모두 읽어와서 화면에 레코드를 행별로 필드를 열에 맞춰서 표시합니다. -->
<table width="800" border="1">
	<tr>
		<th>이름</th><th>아이디</th><th>암호</th><th>전화번호</th><th>수정</th><th>삭제</th>
	</tr>
<% 
	try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, pass);
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while( rs.next() ){
			out.println("<tr>");
			out.println("<td>" + rs.getString("name") + "</td>");
			out.println("<td>" + rs.getString("id") + "</td>");
			out.println("<td>" + rs.getString("pwd") + "</td>");
			out.println("<td>" + rs.getString("phone") + "</td>");
			out.println("<td align='center'><a href='updateForm.jsp?userid="
				+ rs.getString("id") +"'>수정</a></td>");
			out.println("<td align='center'><a href='delete.jsp?userid=" + rs.getString("id") +"'>삭제</a></td>");
			out.println("</tr>");
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
	<tr></tr>
</table>

<a href="insertForm.jsp">멤버 추가</a>
</body>
</html>




