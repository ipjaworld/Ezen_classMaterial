package com.ezen.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.member.dto.MemberDto;
import com.ezen.member.util.Dbman;

public class MemberDao {
   
   // ��Ŭ�� �ڵ�
   
   private MemberDao() {}
   private static MemberDao ist = new MemberDao();
   public static MemberDao getInstance() {
      return ist;
   }
   
   // �����ͺ��̽� Access�� �ʿ��� ��ü
   Connection con = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   
   public MemberDto getMember(String userid) {
      MemberDto mdto =null;
      
      con=Dbman.getConnection();
      String sql="select*from member where userid=?";
      
      try {
         pstmt=con.prepareStatement(sql);
         pstmt.setString (1, userid);
         rs=pstmt.executeQuery();
         if(rs.next()) {
            mdto = new MemberDto();
            mdto.setUserid(rs.getString("userid"));
            mdto.setName(rs.getString("name"));
            mdto.setPwd(rs.getString("pwd"));
            mdto.setPhone(rs.getString("phone"));
            mdto.setEmail(rs.getString("email"));
            mdto.setAdmin(rs.getInt("admin"));
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         Dbman.close(con, pstmt, rs);
      }
      
      return mdto;
   }


   public ArrayList<MemberDto> selectMember() {
      // ��üȸ�� ��ȸ�ؼ� �ǵ��ư��� �޼���
      
      ArrayList<MemberDto> list = new ArrayList<MemberDto>();
      
      con = Dbman.getConnection();
      String sql ="select*from member";
      
      try {
         pstmt=con.prepareStatement(sql);
         rs=pstmt.executeQuery();
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
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         Dbman.close(con, pstmt, rs);
      }
      
      return list;
   }
   
   public int insertMember(MemberDto mdto) {
      int result = 0;
      con = Dbman.getConnection();
      String sql =" insert into member values(?, ?, ?, ?, ?, ?)";
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, mdto.getUserid());
         pstmt.setString(2, mdto.getName());
         pstmt.setString(3, mdto.getPwd());
         pstmt.setString(4, mdto.getPhone());
         pstmt.setString(5, mdto.getEmail());
         pstmt.setInt(6, mdto.getAdmin());
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
      return result;
   }


public int updateMember(MemberDto mdto) {
   int result = 0;
   con = Dbman.getConnection();
   String sql ="update member set name=?, pwd=?, email=?, phone=?,"
         + " admin=? where userid=?";
   try {
      pstmt = con.prepareStatement(sql);
      
      pstmt.setString(1, mdto.getUserid());
      pstmt.setString(2, mdto.getName());
      pstmt.setString(3, mdto.getPwd());
      pstmt.setString(4, mdto.getPhone());
      pstmt.setString(5, mdto.getEmail());
      pstmt.setInt(6, mdto.getAdmin());
      
      result = pstmt.executeUpdate();
   } catch (SQLException e) {e.printStackTrace();
   } finally {Dbman.close(con, pstmt, rs);}
   return result;
}


public void deleteMember(String userid) {

   String sql = "delete from member where userid=?";
   con = Dbman.getConnection();
   try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, userid);
      pstmt.executeUpdate();
   } catch (SQLException e) {e.printStackTrace();
   } finally {Dbman.close(con, pstmt, rs);}
   
}

   
   
   
}