package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookList_Select {

	public static void main(String[] args) {
		
		//JDBC01  패캐지의 코드를 참고하여 booklist 테이블의 레코드 전체를 조회해서 화면에 출력하세요
		// 출력양식은  System.out.println("도서번호\t출판년도\t입고가격\t출고가격\t등급\t제목");  이순서로 출력합니다

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection( url, "scott", "tiger");
			
			String sql = "select * from booklist";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("도서번호\t출판년도\t입고가격\t출고가격\t등급\t제목");
			System.out.println("-----------------------------------------------------------");
			while( rs.next() ) {  // rs.next() 의 리턴값이 존재하면 반복을 계속해주세요
				int booknum = rs.getInt("booknum");
				// int booknum = rs.getInt(0);
				String subject = rs.getString("subject");
				int makeyear = rs.getInt("makeyear");
				int inprice = rs.getInt("inprice");
				int rentprice = rs.getInt("rentprice");
				String grade = rs.getString("grade");
				System.out.printf("%8d\t%d \t%d\t%d \t%s\t%s\n", 
						booknum, makeyear, inprice, rentprice, grade, subject);
			}
			
			
		} catch (ClassNotFoundException e) {  e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		}
		
		
		try {
			if( con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) { e.printStackTrace();
		}
		
				
	}

}
