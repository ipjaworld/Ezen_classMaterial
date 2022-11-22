package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Booklist_Delete {

	public static void main(String[] args) {
		
		// 수정할 도서코드를 입력받고 도서가 없으면 없다고 안내, 있으면 삭제
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			Scanner sc = new Scanner(System.in);	
			System.out.print("삭제할 도서의 도서번호를 입력하세요: ");
			int booknum = Integer.parseInt( sc.nextLine() );
			String sql ="select * from booklist where booknum=?";
			pstmt = con.prepareStatement(sql);			
			pstmt.setInt(1,  booknum);
			if(!rs.next()) {
				System.out.println("입력하신 도서번호의 도서가 존재하지 않습니다");
				return;
			}
			sql = "delete from booklist where booknum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  booknum);
			int result = pstmt.executeUpdate();
			if(result == 1)System.out.println("삭제 성공 ~");
			else	System.out.println("삭제 실패 ㅠ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
			if(rs != null) rs.close();
		} catch (SQLException e) { e.printStackTrace();	}

	}

}
