package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.dto.BoardDto;
import com.board.util.Dbman;
import com.board.util.Paging;

public class BoardDao {
	private BoardDao() {};
	private static BoardDao ist = new BoardDao();
	public static BoardDao getInstance() { return ist; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<BoardDto> selectAll(Paging paging){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		String sql = "select * from("
				+ " select * from ( "
				+ " select rownum as rn, b. * from((select*from mboard order by num desc) b)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				BoardDto bdto = new BoardDto();
				
				bdto.setContent(rs.getString("content"));
				bdto.setEmail(rs.getString("email"));
				bdto.setName(rs.getString("name"));
				bdto.setNum(rs.getInt("num"));
				bdto.setTitle(rs.getString("title"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(bdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);
		}

		return list;
	}


	public int getAllcount() {
		int count = 0;
		String sql = "select count(*) as cnt from mboard";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next() ) count = rs.getInt("cnt");
		} catch(SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		return count;
	}

}
