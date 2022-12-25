package JDBC04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {
	
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			/*
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
			*/
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			con = DriverManager.getConnection( url, "scott", "tiger");
			System.out.println("오라클 연결 성공");
			System.out.println(con);
			
			String sql = "select * from scott.booklist";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
