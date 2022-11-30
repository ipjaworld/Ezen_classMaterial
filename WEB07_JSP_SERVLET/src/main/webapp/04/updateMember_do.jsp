<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>

<% 

request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

Connection con = null;
PreparedStatement pstmt = null;

String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";

String name = request.getParameter("name");
String userid = request.getParameter("userid");	// updateForm에서 수정이 되었을수도 있는 userid
String pwd = request.getParameter("pwd");
String phone = request.getParameter("phone");
String updateid = request.getParameter("updateid");

String sql = "update mem set NAME=?, PWD=?, PHONE=? where ID=?";

try {
	Class.forName(driver);
	con = DriverManager.getConnection(url, "scott", "tiger");

	pstmt = con.prepareStatement(sql);
	
	pstmt.setString(1, name);
	if(pwd != null) pstmt.setString(2, pwd);
	pstmt.setString(3, phone);
	pstmt.setString(4, userid);
	
	pstmt.executeUpdate();
	
}catch(Exception e){ e.printStackTrace(); 
}finally{
	try{
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}catch(Exception e){ e.printStackTrace(); }
}
response.sendRedirect("MemberMGR.jsp");



%>