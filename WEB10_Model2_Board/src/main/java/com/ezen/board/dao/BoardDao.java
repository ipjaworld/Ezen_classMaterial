package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.util.Dbman;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao itc = new BoardDao();
	public static BoardDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
		con = Dbman.getConnection();
		String sql = "select * from board order by num desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setNum( rs.getInt("num") );
				bdto.setPass( rs.getString("pass") );
				bdto.setUserid( rs.getString("userid") );
				bdto.setEmail( rs.getString("email") );
				bdto.setTitle( rs.getString("title") );
				bdto.setContent( rs.getString("content") );
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate( rs.getTimestamp("writedate") );
				
				list.add(bdto);
			}
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public void readCountPlusOne(String num) {
		
		con = Dbman.getConnection();
		String sql = "update board set readcount = readcount+1 where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}

	}

	public BoardDto getBoard(String num) {
		BoardDto bdto = null;
		
		con = Dbman.getConnection();
		String sql = "select * from board where num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto = new BoardDto();
				bdto.setNum( rs.getInt("num") );
				bdto.setPass( rs.getString("pass") );
				bdto.setUserid( rs.getString("userid") );
				bdto.setEmail( rs.getString("email") );
				bdto.setTitle( rs.getString("title") );
				bdto.setReadcount( rs.getInt("readcount") );
				bdto.setWritedate( rs.getTimestamp("writedate") );
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}
		return bdto;
	}

	public BoardDto selectBoardOne(String num) {
		BoardDto bdto = null;
		
		con = Dbman.getConnection();
		String sql = "update board set readcount = readcount+1 where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
			
			sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto = new BoardDto();
				bdto.setNum( rs.getInt("num") );
				bdto.setPass( rs.getString("pass") );
				bdto.setUserid( rs.getString("userid") );
				bdto.setEmail( rs.getString("email") );
				bdto.setTitle( rs.getString("title") );
				bdto.setReadcount( rs.getInt("readcount") );
				bdto.setWritedate( rs.getTimestamp("writedate") );
			}
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
		return null;
	}

	public int insertBoard(BoardDto bdto) {
		int result = 0;
		con = Dbman.getConnection();
		String sql = "insert into board(num, pass, userid, email, title, content, readcount, writedate) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bdto.getNum() );
			pstmt.setString(2, bdto.getPass() );
			pstmt.setString(3, bdto.getUserid() );
			pstmt.setString(4, bdto.getEmail() );
			pstmt.setString(5, bdto.getTitle() );
			pstmt.setString(6, bdto.getContent()) );
			pstmt.setInt(5, bdto.getReadcount() );
			pstmt.setString(5, bdto.getWritedate() );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		
		return result;
		
	}
}
