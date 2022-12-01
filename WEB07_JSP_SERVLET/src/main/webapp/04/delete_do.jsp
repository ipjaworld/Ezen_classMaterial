<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.SQLException" %>

<%!
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";

Connection con = null;
PreparedStatement pstmt = null;

String sql = "delete from mem where ID=?";
%>

<%
	String userid = request.getParameter("userid");
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, "scott", "tiger");
		pstmt= con.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.executeUpdate();
	}catch (SQLException e) {  e.printStackTrace();
	}catch(Exception e){ e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){ e.printStackTrace(); }
	}
	response.sendRedirect("MemberMGR.jsp");

%>