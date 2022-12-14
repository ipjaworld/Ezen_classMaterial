package com.ezen.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.dto.MemberDto;

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

	public MemberDto getMember(String userid) {
		MemberDto mdto = null;
		
		// 전달된 userid로 검색해서 해당 회원이 없으면 null 값이 리턴되도록 dto의 초기값은 null 입니다
		// 조회된 회원이 있는 경우에 new MemberDto가 실행되어 회원의 각 정보를 저장하고 리턴합니다.
		
		con = getConnection();
		String sql = "select * from member where userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mdto = new MemberDto();
				mdto.setName( rs.getString("name" ));
				mdto.setUserid( rs.getString("userid" ));
				mdto.setPwd( rs.getString("pwd" ));
				mdto.setEmail( rs.getString("email" ));
				mdto.setPhone( rs.getString("phone" ));
				mdto.setAdmin( rs.getInt("admin") );
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { close();
		}
		
		return mdto;
	}

	public int insertMember(MemberDto mdto) {
		int result = 0;
		con = getConnection();
		String sql = "insert into member(userid, name, pwd, phone, email, admin) "
				+ "values(?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getUserid() );
			pstmt.setString(2, mdto.getName() );
			pstmt.setString(3, mdto.getPwd() );
			pstmt.setString(4, mdto.getPhone() );
			pstmt.setString(5, mdto.getEmail() );
			pstmt.setInt(6, mdto.getAdmin() );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally { close(); }
		
		return result;
	}

	public int updateMember(MemberDto mdto) {
		int result = 0;
		con = getConnection();
		String sql = "update member set name=?, pwd=?, email=?, phone=?, admin=? where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName() );
			pstmt.setString(2, mdto.getPwd() );
			pstmt.setString(3, mdto.getEmail() );
			pstmt.setString(4, mdto.getPhone() );
			pstmt.setInt(5, mdto.getAdmin() );
			pstmt.setString(6, mdto.getUserid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {  e.printStackTrace();
		} finally { close(); }
		return result;
	}

	public int deleteMember(String userid) {
		int result = 0;
		con = getConnection();
		String sql = "delete from member where userid = ?";
		//String userid = 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid );
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { close(); 
		}
		return result;
		
	}

	public ArrayList<MemberDto> selectMembers() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		con = getConnection();
		String sql = "select * from member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setUserid(rs.getString("userid"));
				mdto.setName(rs.getString("name"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAdmin(rs.getInt("admin"));
				
				list.add(mdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally { close(); }
		
		return list;
	}

	public void editAdmin(String userid, int admin) {
		con = getConnection();
		String sql = "update member set admin=? where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, admin);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {  e.printStackTrace();
		} finally { close(); }
	}
	
	
	
}
