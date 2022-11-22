package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connect {

	public static void main(String[] args) {
		
		// 오라클 데이터 베이스에 연결핣니다
		
		// 연결을 위해서는 연결 대상의 url,  연결시필요한 driver 파일의 이름, 젒속 가능한 아이디, 패스워드 가 필요합니다.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";   // 연결을 위한 주소
		String driver = "oracle.jdbc.driver.OracleDriver";   // 연결을 위한 드라이버
		String id = "scott";
		String pw = "tiger";
		
		// JDBC 를 통한 데이터 베이스 연결을 관리하는 클래스 : Connection
		Connection con = null;
		
		try {
			// driver 변수에 저장된 드라이버 파일을 찾아서 장착합니다. 
			Class.forName(driver);
			
			// 연결 드라이버 메니져가 데이터베이스 연결을 하고, 연결 해준 연결 인스턴스를 con 변수에 저장
			con = DriverManager.getConnection(url, id, pw);
			
			System.out.println("데이터베이스에 연결 성공했습니다");
			// 데이터베이스 작업 #1
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();  
			System.out.println("드라이버 파일을 확인하세요");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("오라클 프로그램 설치 및 url, id, pass 를 확인 하세요");
		} catch (Exception e) {
			System.out.println("별도의 사유로 인한 연결 실패 ㅠㅠ");
		}
		
		
		// 데이터베이스 작업 #2  : 이 영역은 잘 이용하지 않습니다.
		
		
		try {
			if( con != null ) con.close();
			System.out.println("데이터베이스 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
