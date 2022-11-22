package JDBC03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Dao : Database Access Object
// 데이터베이스 관련 작업과 데이터 이등을 전담하는 클래스이며, 
// 연결에 필요한 정보는 멤버변수에 저장하고,
// 연결과 각 CRUD(Insert Select Update  Delete 네동작을 지징하는 약자)작업을 멤버 메서드를 만들어서 작동하게 합니다
public class MemberDao {
	
	// 연결에 필요한 정보는 멤버변수에
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = null;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	public Connection getConnection() {
		Connection con = null;  // 지역변수로서의 con
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");	
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) { e.printStackTrace();
		}
		return con;
	}
	public void close() {
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();			
		} catch (SQLException e) {	e.printStackTrace();	}
	}
	
	
	// 연결하고 조회하는 동작은 멤버 메서드에 
	public ArrayList<MemberDto> selectAll() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con = getConnection();			
		String sql = "select * from memberlist";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next() ) {
				// 레코드 하나에 들어있는 필드값들을 MemberDto 객체에 각각 저장하고
				// 객체는 ArrayList에  add 합니다
				MemberDto mdto = new MemberDto();
				// int membernum = rs.getInt("membernum");
				// mdto.setMembernum( membernum );
				mdto.setMembernum( rs.getInt("membernum") );
				mdto.setName( rs.getString("name") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setBirth( rs.getDate( "birth") );
				mdto.setBpoint( rs.getInt("bpoint") );
				mdto.setJoindate( rs.getDate("joindate") );
				mdto.setGender( rs.getString("gender") );
				mdto.setAge( rs.getInt("age") );
				list.add(mdto);
			}
		} catch (SQLException e1) {   e1.printStackTrace();
		}
		close();
		return list;
	}


	public int insert(MemberDto mdto) {
		int result = 0;
		con = getConnection();
		String sql = "insert into memberlist( membernum, name, phone, birth, gender, age) "
				+ " values( member_seq.nextVal, ? , ? , ? , ? , ? )";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString( 1, mdto.getName() );
			pstmt.setString(2,  mdto.getPhone() );
			pstmt.setDate( 3, mdto.getBirth() );
			pstmt.setString( 4, mdto.getGender() );
			pstmt.setInt( 5, mdto.getAge() );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {  e.printStackTrace();
		}
		close();
		return result;
	}
	
	public MemberDto selectOne( int membernum ) {
		MemberDto mdto = null;  
		// 전달된 회원번호로 검색했을때 회원이 존재하지 않으면 null 상태를 유지하게 합니다
		// 회원이 있으면 그 회원정보로 mdto 를 채웁니다
		
		con = getConnection();
		String sql = "select * from memberlist where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membernum);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mdto = new MemberDto();
				mdto.setMembernum(membernum);
				mdto.setName( rs.getString("name") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setBirth( rs.getDate("birth") );
				mdto.setBpoint( rs.getInt("bpoint") );
				mdto.setJoindate( rs.getDate("joindate") );
				mdto.setGender( rs.getString("gender") );
				mdto.setAge( rs.getInt("age") );
			}
		} catch (SQLException e) {  e.printStackTrace();
		}
		close();
		return mdto;
	}
	public int update(MemberDto mdto) {
		int result = 0;
		
		con = getConnection();
		String sql = "update memberlist set name=?, phone=?, birth=?, bpoint=?, "
				+ " joindate=? , gender=?, age=?  where membernum = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName() );
			pstmt.setString(2, mdto.getPhone() );
			pstmt.setDate( 3,  mdto.getBirth() );
			pstmt.setInt( 4,  mdto.getBpoint() );
			pstmt.setDate(5, mdto.getJoindate() );
			pstmt.setString( 6, mdto.getGender() );
			pstmt.setInt( 7, mdto.getAge() );
			pstmt.setInt( 8, mdto.getMembernum() );
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		}
		close();
		return result;
	}

}















