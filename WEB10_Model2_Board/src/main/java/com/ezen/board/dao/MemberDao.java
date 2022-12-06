package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.util.Dbman;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDto getMember(String userid) {
		MemberDto mdto = null;
		con = Dbman.getConnection();
		String sql = "select * from member where userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setUserid( rs.getString("userid" ) );
				mdto.setName(rs.getString("name" ));
				mdto.setPwd(rs.getString("pwd" ));
				mdto.setEmail(rs.getString("email" ));
				mdto.setPhone(rs.getString("phone" ));
				mdto.setAdmin(rs.getInt("admin" ));
			}
			
		}catch(SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);
			
		}
		
		return mdto;
	}
}
