package JDBC04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDao {

	// 생성자를  private 으로 만들어서 외부에서 생성자를 사용할 없게 만듭니다.
	private RentDao() {}
	// 클래스 내부에서 딱한개 유일한 객체를 생성합니다. private static 으로 private 요소는 클래스 내부에서 제한없이 사용이 가능
	private static RentDao itc = new RentDao();
	// 외부에서  itc를 리턴 받아 쓸수 있게해주는  public static 메서드를 생성합니다
	public static RentDao getInstance() {	return itc;		}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// DataBaseManager dbm = new DataBaseManager();
	
	//String driver = "oracle.jdbc.driver.OracleDriver";
	//String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//String id = "scott";
	//String pw = "tiger";
	
	public ArrayList<RentDto> selectAll(){
		ArrayList<RentDto> list = new ArrayList<RentDto>();
		con = DataBaseManager.getConnection();

		String sql = "select   to_char(rentdate, 'YYYY-MM-DD') as rd , numseq, booknum, "
				+ "membernum, discount    from rentlist";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				RentDto rdto = new RentDto();
				rdto.setRentdate(  rs.getString("rd") );
				rdto.setNumseq( rs.getInt("numseq") );
				rdto.setBooknum( rs.getInt("booknum") );
				rdto.setMembernum( rs.getInt("membernum") );
				rdto.setDiscount( rs.getInt("discount") );
				
				list.add(rdto);
			}
		} catch (SQLException e) {  e.printStackTrace();
		}
		DataBaseManager.close(con, pstmt, rs);
		return list;
	}

	
	public String getSubject(String booknum) {
		
		String rentprice = null;
		con = DataBaseManager.getConnection();
		String sql = "select rentprice from booklist where booknum = ?";	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  Integer.parseInt( booknum ) );
			rs = pstmt.executeQuery();
			if( rs.next() ) rentprice = String.valueOf( rs.getInt("rentprice") ) ;			
		} catch (SQLException e) {  e.printStackTrace();
		}
		DataBaseManager.close(con, pstmt, rs);		
		return rentprice;
	}


	public int insert(RentDto rdto) {
		int result = 0;
		
		con = DataBaseManager.getConnection();
		String sql = "insert into rentlist( rentdate, numseq, booknum, membernum, discount) "
				+ " values( sysdate , rent_seq.nextVal, ? , ? , ? )";
		// 입력 받은 날짜를 레코드에 넣으려면 
		// sysdate ->  to_date( ''||?||'' , 'YYYYMMDD')
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBooknum());
			pstmt.setInt(2, rdto.getMembernum());
			pstmt.setInt(3, rdto.getDiscount());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {  e.printStackTrace();
		} finally {  DataBaseManager.close(con, pstmt, rs);   
		}		
		return result;
	}


	public RentDto selectOne(int numseq) {
		RentDto rdto = null;
		con = DataBaseManager.getConnection();
		String sql = " select to_char(rentdate, 'YYYY-MM-DD') as rd,  numseq, booknum, membernum, "
				+  " discount  from rentlist where numseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, numseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				rdto = new RentDto();
				rdto.setRentdate( rs.getString("rd") );
				rdto.setNumseq(numseq);
				rdto.setBooknum(rs.getInt("booknum") );
				rdto.setMembernum( rs.getInt("membernum" ) );
				rdto.setDiscount( rs.getInt("discount") );
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs);
		}
		return rdto;
	}


	public int update(RentDto rdto) {
		int result = 0;
		
		con = DataBaseManager.getConnection();
		String sql = "update rentlist set rentdate = to_date(''||?||'', 'YYYY-MM-DD') , booknum =?, "
				+ " membernum=?, discount=? where numseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rdto.getRentdate() );
			pstmt.setInt(2, rdto.getBooknum() );
			pstmt.setInt(3, rdto.getMembernum() );
			pstmt.setInt(4, rdto.getDiscount() );
			pstmt.setInt(5, rdto.getNumseq() );
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {  e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs);  
		}
		return result;
	}


	public int delete(String numseq) {
		int result = 0;
		con = DataBaseManager.getConnection();
		String sql = "delete from rentlist where numseq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt( numseq ) );
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DataBaseManager.close(con, pstmt, rs); 
		}
		return result;
	}
}











