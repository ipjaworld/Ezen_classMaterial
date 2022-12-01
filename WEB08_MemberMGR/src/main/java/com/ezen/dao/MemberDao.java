package com.ezen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	// 연결 정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pw = "tiger";
	
	// 연결객체 준비
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public  Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) { 	e.printStackTrace();
		} catch (SQLException e) { 	e.printStackTrace();		}
		return con;
	}
	
	private void close() {
		try {
			if (rs!=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
