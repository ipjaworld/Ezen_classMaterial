package com.ezenac.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.shop.dto.OrderVO;
import com.ezenac.shop.dto.ProductVO;
import com.ezenac.shop.dto.QnaVO;
import com.ezenac.shop.util.Dbman;
import com.ezenac.shop.util.Paging;

public class AdminDao {

	private AdminDao(){};
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public String workerCheck(String workId) {
		String pwd = null;
		
		String sql = "select * from worker where id = ?";
		con = Dbman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, workId);
			rs = pstmt.executeQuery();
			if( rs.next() )
				pwd = rs.getString("pwd");
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		
		return pwd;
	}


	public ArrayList<ProductVO> selectProduct() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		con = Dbman.getConnection();
		String sql = "select * from product order by pseq desc";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				ProductVO pvo = new ProductVO();
				//pstmt.setInt(1, paging.getStartNum());
				//pstmt.setInt(2, paging.getEndNum());
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				list.add(pvo);
			}
				
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs); }
		
		return list;
	}


	public int getAllcount(String tableName, String fieldName, String key) {
		int count = 0;
		
		String sql = "select count(*) as cnt from "+ tableName + " where" + fieldName +  "like '%'||?||'%'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if( rs.next() ) count = rs.getInt("cnt");
		} catch(SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
		return count;
	}


	public ArrayList<ProductVO> selectProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "select * from("
				+ " select * from ( "
				+ " select rownum as rn, p. * from "
				+ " ((select*from product where name like '%'||?||'%' order by pseq desc) p)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				ProductVO pvo = new ProductVO();
				
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				
				
				list.add(pvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}


	public void insertProduct(ProductVO pvo) {

		con = Dbman.getConnection();
		String sql = "insert into product( pseq, kind, name, price1, price2, price3,"
				+ " content, image) values( product_seq.nextVal, ? , ? , ? , ?, ?, ?, ? )";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1, pvo.getKind());
			pstmt.setString( 2, pvo.getName() );
			pstmt.setInt( 3, pvo.getPrice1() );
			pstmt.setInt( 4, pvo.getPrice2() );
			pstmt.setInt( 5, pvo.getPrice3() );
			pstmt.setString( 6, pvo.getContent()  ) ;
			pstmt.setString( 7, pvo.getImage() );
			pstmt.executeUpdate();
		} catch (SQLException e) {  e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
	}


	public void updateProduct(ProductVO pvo) {
		con = Dbman.getConnection();
		String sql = "update product set kind=?, useyn=?, name=?, price1=?, "
				+ " price2=?, price3=?, content=?, image=?, bestyn=? where pseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getUseyn());
			pstmt.setString(3, pvo.getName());
			pstmt.setInt(4, pvo.getPrice1());
			pstmt.setInt(5, pvo.getPrice2());
			pstmt.setInt(6, pvo.getPrice3());
			pstmt.setString(7, pvo.getContent());
			pstmt.setString(8, pvo.getImage());
			pstmt.setString(9, pvo.getBestyn());
			pstmt.setInt(10, pvo.getPseq());
			pstmt.executeUpdate();
		
		
		} catch (SQLException e) {  e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
	}


	public ArrayList<OrderVO> selectOrder(Paging paging, String key) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		String sql = "select * from("
				+ " select * from ( "
				+ " select rownum as rn, p. * from "
				+ " ((select*from product where name like '%'||?||'%' order by pseq desc) p)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				OrderVO ovo = new OrderVO();
				
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setMname(rs.getString("mname"));
				ovo.setAddress1(sql);
				ovo.setId(sql);
				ovo.setPhone(sql);
				ovo.setPname(sql);
				ovo.setPrice2(0);
				ovo.setQuantity(0);
				ovo.setZip_num(sql);
				ovo.setResult(sql);

				list.add(ovo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);
		}
		
		return list;
	}
	
}
