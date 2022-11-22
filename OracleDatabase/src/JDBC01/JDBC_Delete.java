package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Delete {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			Scanner sc = new Scanner(System.in);
		
			System.out.print("삭제할 번호를 입력하세요: ");
			int num = sc.nextInt();			
			String sql = "delete from customer where num=?";  // sql 문 제작
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int result = pstmt.executeUpdate();  // 실행
			if(result == 1)System.out.println("삭제 성공 ~");
			else	System.out.println("삭제 실패 ㅠ");
			
		} catch (ClassNotFoundException e) {    e.printStackTrace();
		} catch (SQLException e) {  	e.printStackTrace();
		}
		try {
			if(pstmt != null)pstmt.close();
			if(con != null)con.close();
		} catch (SQLException e) { e.printStackTrace();	}


	}

}
