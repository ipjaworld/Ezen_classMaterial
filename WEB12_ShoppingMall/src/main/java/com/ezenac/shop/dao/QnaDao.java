package com.ezenac.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.shop.dto.QnaVO;
import com.ezenac.shop.util.Dbman;
import com.ezenac.shop.util.Paging;

public class QnaDao {

	private QnaDao() {}
	private static QnaDao ist = new QnaDao();
	public static QnaDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	 
	public ArrayList<QnaVO> selectQna(String id) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "select * from qna where id=? order by qseq desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				list.add(qvo);
			}
		}catch(SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public int getAllcount(String id) {
		int count = 0;
		
		String sql = "select count(*) as cnt from qna where id =?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if( rs.next() ) count = rs.getInt("cnt");
		} catch(SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
		return count;
	}
	
	public ArrayList<QnaVO> selectQna(String id, Paging paging){
		ArrayList<QnaVO> list = new ArrayList<>();
		String sql = "select * from("
				+ " select * from ( "
				+ " select rownum as rn, q. * from((select*from qna where id=? order by qseq desc) q)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				list.add(qvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}
	
}
