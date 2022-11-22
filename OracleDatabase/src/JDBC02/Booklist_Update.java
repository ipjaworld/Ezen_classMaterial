package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Booklist_Update {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			Scanner sc = new Scanner(System.in);	
			System.out.print("수정할 도서의 도서번호를 입력하세요: ");
			int booknum = Integer.parseInt( sc.nextLine() );
			
			String sql ="select * from booklist where booknum=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,  booknum);
			
			rs = pstmt.executeQuery();
			String subject;
			int makeyear;
			int inprice;
			int rentprice;
			String grade;
			
			if(rs.next()) {
				subject = rs.getString("subject");
				makeyear = rs.getInt("makeyear");
				inprice = rs.getInt("inprice");
				rentprice = rs.getInt("rentprice");
				grade = rs.getString("grade");
			}else {
				System.out.println("입력하신 도서번호의 도서가 존재하지 않습니다");
				return;
			}
			
			String temp;
			System.out.println("도서의 제목 : " + subject );
			System.out.print("수정할 제목을 입력하세요. 수정하지 않으려면 엔터를 입력하세요 : ");
			temp = sc.nextLine();
			if( !temp.equals("") ) subject = temp; 
			
			System.out.println("출판년도 : " + makeyear );
			System.out.print("수정할 출판년도를 입력하세요. 수정하지 않으려면 엔터를 입력하세요 : ");
			temp = sc.nextLine();
			if( !temp.equals("") ) makeyear = Integer.parseInt( temp ); 
			
			System.out.println("입고가격 : " + inprice );
			System.out.print("수정할 입고가격을 입력하세요. 수정하지 않으려면 엔터를 입력하세요 : ");
			temp = sc.nextLine();
			if( !temp.equals("") ) inprice = Integer.parseInt( temp ); 
			
			System.out.println("대여가격 : " + rentprice );
			System.out.print("수정할 대여가격을 입력하세요. 수정하지 않으려면 엔터를 입력하세요 : ");
			temp = sc.nextLine();
			if( !temp.equals("") ) rentprice = Integer.parseInt( temp ); 
			
			System.out.println("등급 : " + grade );
			System.out.print("수정할 등급을 입력하세요. 수정하지 않으려면 엔터를 입력하세요 : ");
			temp = sc.nextLine();
			if( !temp.equals("") ) grade = temp;
			
			sql = "update booklist set subject=?, makeyear=?, inprice=?, rentprice=?, grade=? "
					+ " where booknum=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString( 1, subject);
			pstmt.setInt(2,  makeyear);
			pstmt.setInt(3,  inprice);
			pstmt.setInt(4,  rentprice);
			pstmt.setString(5,  grade);
			pstmt.setInt(6,  booknum);
			
			int result = pstmt.executeUpdate();
			if(result == 1)System.out.println("수정 성공 ~");
			else	System.out.println("수정 실패 ㅠ");
			
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
