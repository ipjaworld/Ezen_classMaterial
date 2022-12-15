package com.ezen.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.product.dto.ProductDto;
import com.ezen.product.util.Dbman;

public class ProductDao {

	private ProductDao() {}
	private static ProductDao itc = new ProductDao();
	public static ProductDao getInstance() { return itc; }
	
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ProductDto> selectAll() {
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		
		String sql = "select * from bookproduct order by code desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				ProductDto pdto = new ProductDto();
				pdto.setCode( rs.getInt("code") );
				pdto.setName( rs.getString("name") );
				pdto.setPrice( rs.getInt("price") );
				pdto.setPictureurl( rs.getString("pictureurl") );
				pdto.setDescription( rs.getString("description") );
				list.add( pdto );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {   Dbman.close(con, pstmt, rs);   }
		
		return list;
	}

	public ProductDto getProduct(int code) {
		ProductDto pdto = null;
		
		String sql = "select * from bookproduct where code=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				pdto = new ProductDto();
				pdto.setCode( rs.getInt("code") );
				pdto.setName( rs.getString("name") );
				pdto.setPrice( rs.getInt("price") );
				pdto.setPictureurl( rs.getString("pictureurl") );
				pdto.setDescription( rs.getString("description") );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {   Dbman.close(con, pstmt, rs);   }
		
		return pdto;
	}

	public void insertProduct(ProductDto pdto) {
		
		con = Dbman.getConnection();
		String sql = "insert into bookproduct( code, name, price, pictureurl, description )"
				+ " values( bookproduct_seq.nextVal, ? , ? , ? , ? )";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdto.getName() );
			pstmt.setInt(2, pdto.getPrice() );
			pstmt.setString(3, pdto.getPictureurl() );
			pstmt.setString(4, pdto.getDescription() );
			
			pstmt.executeUpdate();
		} catch (SQLException e) {  e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
	}

	public void updateProduct(ProductDto pdto) {
		
		String sql = "update bookproduct set name=? , price=? , pictureurl=? , "
				+ "description=? where code=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdto.getName() );
			pstmt.setInt(2, pdto.getPrice()  );
			pstmt.setString(3, pdto.getPictureurl() );
			pstmt.setString(4, pdto.getDescription() );
			pstmt.setInt(5,  pdto.getCode() );
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		
	}

	public void deleteProduct(int code) {
		
		String sql = "delete from bookproduct where code=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code );			
			pstmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		
	}
	
}














