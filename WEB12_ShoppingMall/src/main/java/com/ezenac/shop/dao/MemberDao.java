package com.ezenac.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ezenac.shop.dto.MemberVO;
import com.ezenac.shop.util.Dbman;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() { return  itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberVO getMember(String id) {
		MemberVO mvo = null;
		con = Dbman.getConnection();
		String sql = "select * from member where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setId(rs.getString("id" ));
				mvo.setPwd(rs.getString("pwd" ));
				mvo.setName(rs.getString("name" ));
				mvo.setPwd(rs.getString("pwd" ));
				mvo.setEmail(rs.getString("email" ));
				mvo.setZip_num( rs.getString("zip_num") );
				mvo.setAddress1( rs.getString("address1") );
				mvo.setAddress2( rs.getString("address2") );
				mvo.setPhone( rs.getString("phone" ) );
				mvo.setUseyn( rs.getString("useyn" ) );
				mvo.setIndate( rs.getTimestamp("indate" ) );
			}
		}catch(SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);}
		return mvo;
	}
	
}
