package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Insert {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// insert 명령의 경우 결과값이 따로 없어서 ResultSet 은 사용하지 않습니다
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// System.out.println("연결 성공");
			
			// 화면으로 부터 각 필드값을 입력 받아서 그 데이터들을 필드값으로 하여 레코드를 추가합니다
			Scanner sc = new Scanner(System.in);
			
			System.out.print("저장할 번호를 입력하세요: ");
			int num = Integer.parseInt( sc.nextLine() );
			System.out.print("이름을 입력하세요: ");
			String name = sc.nextLine();
			System.out.print("이메일 입력하세요: ");
			String email = sc.nextLine();
			System.out.print("전화번호를 입력하세요: ");
			String tel = sc.nextLine();
			
			// insert into customer values( 6, '김하나', 'abc6@anc.com', '010-5555-666')
			//String sql = "insert into customer values(" + num + ", '" + name + "' , '" + email + "', '" + tel + "' )";
			// 위에 문장은 옛날 방식
			
			// 아래가 요즘 방식
			String sql = "insert into customer values( ? , ? , ? , ? )";
			
			// 물음표가 있는 SQL 명령 그데로를 먼저 pstmt에 장착하고
			pstmt = con.prepareStatement(sql);
			
			// ? 의 순서 맞춰서 해당 데이터를 지정합니다. 지정의 주체는 pstmt
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, tel);
			// 문자 데이터와 숫자 데이터만 구분해서 setInt  setString 으로 순서에 맞춰서 배치합니다
			
			int result = pstmt.executeUpdate();
			// SQL  select 명령만 excuteQuery 를 사용하고, 나머지는 extcuteUpdate 메서드를 사용합니다
			// extcuteUpdate의 결과는   sql 명령이 정상 동작했을때 1, 실패했을때0 이 리턴됩니다
			
			if( result == 1) System.out.println("레코드 추가 성공");
			else System.out.println("레코드 추가 실패");
			
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
		
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) { e.printStackTrace();	}

	}

}
