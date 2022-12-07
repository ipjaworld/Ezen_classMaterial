package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyDto;
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
				 bdto= new BoardDto();
		         bdto.setNum(rs.getInt("num"));
		         bdto.setPass(rs.getString("pass"));
		         bdto.setUserid(rs.getString("userid"));
		         bdto.setEmail(rs.getString("email"));
		         bdto.setTitle(rs.getString("title"));
		         bdto.setContent(rs.getString("content"));
		         bdto.setReadcount(rs.getInt("readcount"));
		         bdto.setWritedate(rs.getTimestamp("writedate"));
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

	public void insertBoard(BoardDto bdto) {
		con = Dbman.getConnection();
		String sql = "insert into board(num, userid, pass, email, title, content) "
				+ "values(board_seq.nextVal, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid() );
			pstmt.setString(2, bdto.getPass() );
			pstmt.setString(3, bdto.getEmail() );
			pstmt.setString(4, bdto.getTitle() );
			pstmt.setString(5, bdto.getContent() );

			//result = pstmt.executeUpdate();
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }

	}

	public void updateBoard(BoardDto bdto) {
		con = Dbman.getConnection();
		String sql = "update board set userid=?, pass=?, email=?, title = ?, content = ? where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid() );
			pstmt.setString(2, bdto.getPass() );
			pstmt.setString(3, bdto.getEmail() );
			pstmt.setString(4, bdto.getTitle() );
			pstmt.setString(5, bdto.getContent() );
			pstmt.setInt(6, bdto.getNum() );
			
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		
		
	}

	public void deleteBoard(String num) {
		
		String sql = "delete from board where num=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		
	}

	public ArrayList<ReplyDto> selectReply(String num) {
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		
		con = Dbman.getConnection();
		String sql = "select * from reply where boardnum=? order by replynum desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(num) );
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				ReplyDto rdto = new ReplyDto();
				rdto.setReplynum(rs.getInt("replynum"));
				rdto.setBoardnum(rs.getInt("boardnum"));
				rdto.setUserid(rs.getString("userid"));
				rdto.setWritedate(rs.getTimestamp("writedate"));
				rdto.setContent(rs.getString("content"));
				list.add(rdto);
			}
			
		}catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		
		return list;
	}

	public void insertReply(ReplyDto rdto) {
		
		con = Dbman.getConnection();
		String sql = "insert into reply( replynum, boardnum, userid, content)"
				+ " values( reply_seq.nextVal, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBoardnum() );
			pstmt.setString(2, rdto.getUserid() );
			pstmt.setString(3, rdto.getContent() );
			
			pstmt.executeUpdate();

		}catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		
	}

	public void deleteReply(String rpnum) {
		String sql = "delete from reply where replynum=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(rpnum));
			pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		
	}

	public int getReplyCnt(int num) {
		int count=0;
		
		String sql = "select count(*) as cnt from reply where boardnum=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if( rs.next() )
				count = rs.getInt("cnt");
			pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		
		return count;
	}
	
}




