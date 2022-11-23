package JDBC01;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 싱글턴으로 만들기
public class MemberDao {
   
   public MemberDao() {
      
   }
   private static MemberDao itc = new MemberDao();
   public static MemberDao getInstance() {
      return itc;
   }
   
   Connection con = null;
   PreparedStatement pstmt=null;
   ResultSet rs= null;
   
   public ArrayList<MemberDto> selectAll() {
      
      ArrayList<MemberDto> list = new ArrayList<MemberDto>();
      con = Dbmanager.getConnection();         
      String sql = "select membernum, name, date_format(birth,'%Y%m%d') as bd, bpoint, age,"
            + " gender, date_format(joindate,'%Y%m%d') as jd, phone"
            + " from memberlist order by membernum desc";
      try {
         pstmt = con.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next() ) {
            MemberDto mdto = new MemberDto();
            mdto.setMembernum( rs.getInt("membernum") );
            mdto.setName( rs.getString("name") );
            mdto.setBirth( rs.getString( "bd") );
            mdto.setBpoint( rs.getInt("bpoint") );
            mdto.setAge( rs.getInt("age") );
            mdto.setGender( rs.getString("gender") );
            mdto.setJoindate( rs.getString("jd") );
            mdto.setPhone( rs.getString("phone") );

            list.add(mdto);
         }
      } catch (SQLException e1) {   e1.printStackTrace();
      } finally{
         Dbmanager.close(con,pstmt,rs);
      }
      return list;
   }
   

	public MemberDto selectOne(String s) {
		MemberDto mdto = null;

		
		return mdto;
	}


	public void insert(MemberDto mdto) {
		
		con = Dbmanager.getConnection();
		String sql = "insert into memberlist( name, phone, birth, gender, age)"
				+ " values( ?, ?, str_to_date( concat('', ?, ''), '%Y%m%d' ), ?, ?)";
		// concat('', ?, '') -> '' : 작은 따옴표 두개.
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirth());
			pstmt.setString(4, mdto.getGender());
			pstmt.setInt(5, mdto.getAge());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {
			Dbmanager.close(con, pstmt, rs);
		}
		
		
	}


	public MemberDto getMember(int membernum) {
		MemberDto mdto = null;
		con = Dbmanager.getConnection();
		String sql = "select membernum, name, date_format(birth,'%Y%m%d') as bd, bpoint,"
				+ " date_format(joindate,'%Y%m%d') as jd, phone, age, gender"
				+ " from memberlist where membernum = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membernum);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mdto = new MemberDto();
				mdto.setName(sql);
				mdto.setBirth(rs.getString("bd"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setJoindate(rs.getString("jd"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbmanager.close(con, pstmt, rs); }
		
		return mdto;
	}


	public void update(MemberDto mdto) {
		
		
	}
}