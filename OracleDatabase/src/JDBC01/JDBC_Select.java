package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;
		PreparedStatement pstmt = null; // con 에 SQL문을 장착하고 실행해주는 객체
		ResultSet rs = null; // SQL 실행결과를 저장하는 객체
		
		try {
			// 연결은con,   sql 실행은 pstmt,  결과 저장은 rs
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			// System.out.println("데이터베이스에 연결 성공했습니다");
			
			// 데이터베이스 연결후에는 SQL 명령을 사용하기 위해  String 변수에 SQL 명령을 준비합니다.
			// 데이터베이스에 제공되어질 명령이므로 String 형으로 준비합니다
			String sql = "select * from customer";
			
			// SQL 문을  con 에 제공하고 그 객체를   pstmt 에  전달합니다
			pstmt = con.prepareStatement( sql );
			// pstmt = con.prepareStatement( "select * from customer" );
			
			// pstmt 에 담겨진 SQL 명령 실행하고 그 결과를  rs 에 저장합니다
			rs = pstmt.executeQuery();	
			
			System.out.println("번호 \t 이름 \t\t 이메일 \t\t\t 전화번호");
			System.out.println("----------------------------------------------------");
			
			// rs에 저정된 결과는 일단 레코드 단위로 접근이 가능합니다.
			// 최초 rs 의 참조값은 select 결과의 맨 앞부분보다 더 앞부분 begin위치를 저장합니다
			//  rs 의 메서드중 next()라는 메서드로 처음레코드로 접근이 가능하며, 이후 계속 next()라는 메서드로 다음 레코드,
			// 다음 레코드에 접근합니다.
			// 한 레코드에 포거스가 있을때는  rs.getInt("필드명")   rs.getString("필드명")  그레코드의 각 필드값을 얻을 수 있습니다
			
			while( rs.next() ) {
				// rs.next()로 첫번째 레코드로 이동후 반복이 실행됩니다.
				// rs.next() 메서드로 이동했는데 이제 레코드 더이상 없다면 반복은 멈춥니다.
				// 레코드 갯수 만큼 반복하고 끝납니다
				
				// rs.getInt() : number 형 필드값을 추출하는 메서드. 괄호안에 필드이름을 정확히 써야합니다.
				// rs.getString() : varchar2 형 필드값을 추출하는 메서드
				int num = rs.getInt("num");
				// 모든 자료형에 대해 get~() 메서드가 모두 실행가능합니다
				String name = rs.getString("name");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				System.out.printf("%d \t %s \t %s \t %s\n", num, name,email,tel);
			}			
		} catch (ClassNotFoundException e) {   e.printStackTrace();  
		} catch (SQLException e) {	e.printStackTrace();
		} catch (Exception e) {	System.out.println("별도의 사유로 인한 연결 실패 ㅠㅠ");
		}
		
		try {
			if( con != null ) con.close();
			System.out.println("데이터베이스 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
