package BaseBall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOHidden {
	protected Connection conn;
	protected PreparedStatement psmt;
	protected ResultSet rs;
	
	protected void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "cgi_5_3";
			String db_pw = "smhrd3";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void close() {
		try {
			if (rs != null) { // null 값이 아닐 때 
				rs.close(); // 역순으로 닫기
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	public void createMemberTable(MemberVO vo) { //[[회원관리테이블]]
		getConn();
		 try {
	         String sql = "create table ballmember (memberId number(15),"
	               + "password varchar2(15),"
	               + "nick varchar2(10),"
	               + "idCode number(2),"
	               + "score number(5),"
	               + "play1 number(2),"
	               + "play2 number(2),"
	               + "play3 number(2),"
	               + "play4 number(2),"
	               + "play5 number(2),"
	               + "play6 number(2),"
	               + "play7 number(2),"
	               + "play8 number(2),"
	               + "play9 number(2))";
	               
	         psmt = conn.prepareStatement(sql);
	         
	         psmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         close();
	      }
		
	}
	
	public void createPlayerTable() { //선수테이블
		getConn();
		
		 try {
	         String sql  = "create table BaseBallPlayer values(id number(2), name varhar2(15), team varchar2(10),"
	               + "pa number(5),"
	               + "single number(5),"
	               + "doubl number(5),"
	               + "triple number(5),"
	               + "hr number(5),"
	               + "sb number(5),"
	               + "sbf number(5),"
	               + "bb number(5),"
	               + "hbp number(5),"
	               + "so number(5),"
	               + "gt number(5),"
	               + "fly number(5))";
	         psmt = conn.prepareStatement(sql);
	                 
	         psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	
	public int count () {
		int result = 0;
		getConn();
		
		try {
			String sql = "select  count(idCode) \"COUNT\" from Members";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			result = Integer.parseInt(rs.getString("COUNT"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close();
		}
		
		
		return result;
	}
	
	

}
