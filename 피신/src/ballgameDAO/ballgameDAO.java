package ballgameDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.MemberVO;

public class ballgameDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
//----------------------------------------------------------------------------------	
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ClassNotFoundException
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			// @localhost ip주소, 1521 데이터베이스 포트 넘버, xe - 오라클 별칭 (버전)
			String db_id = "cgi_5_3";
			String db_pw = "smhrd3";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//----------------------------------------------------------------------------	
	private void close() {
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
	
	public void createtable() { //선수테이블
		int cnt = 0;
		getConn();
		
		try {
			String sql = "create table ballmember (memberId varchar2(20), \r\n"
					+ "password varchar2(5, 0), \r\n"
					+ "nick varchar2(5, 0), \r\n"
					+ "idCode varchar2(5, 0), \r\n"
					+ "score number(5, 0), \r\n"
					+ "member number(5, 0), \r\n";
					
			psmt = conn.prepareStatement(sql);
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public int createJoin(MemberVO vo) { //[[회원관리테이블]]
		int cnt = 0;
		getConn();
		
		try {
			String sql  = "create table join values(id number(20), name varhar2(15), team varchar2(10 byte),\r\n"
					+ "pa number(5, 0),\r\n"
					+ "single number(5, 0),\r\n"
					+ "doubl number(5, 0),\r\n"
					+ "triple number(5, 0),\r\n"
					+ "hr number(5, 0),\r\n"
					+ "sb number(5, 0),\r\n"
					+ "sbf number(5, 0),\r\n"
					+ "bb number(5, 0),\r\n"
					+ "hbp number(5, 0),\r\n"
					+ "so number(5, 0),\r\n"
					+ "gt number(5, 0),\r\n"
					+ "fly number(5, 0))";
			psmt = conn.prepareStatement(sql);
			
			
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean inPutMember(MemberVO member) {
		boolean cnt = true;

		getConn();
		try {
			String sql = "insert into Member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getPassword());
			psmt.setString(3, member.getNick());
			psmt.setString(4, member.getIdCode());
			psmt.setString(5, Integer.toString(member.getScore()));
			for(int i =6; i < 15; i++) {
				psmt.setString(i, Integer.toString(member.getMember()[i-6]));

			}
			psmt.executeUpdate();
		}catch (SQLException e) {
			cnt = false;
			e.printStackTrace();
		}finally {
			
			close();
		}
		return cnt;
	}	
	
	
	public MemberVO outPutMember(int id) {
		MemberVO vo = null;
		getConn();
		String sql = "select * from Ballmember where id = ?";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(id));
			rs = psmt.executeQuery();
			rs.next();
			String memberId =rs.getString("memberId");
			String password =  rs.getString("password");
			String nick = rs.getString("nick");
			String idCode = rs.getString("idCode");
			int score = Integer.parseInt(rs.getString("score"));
			int[] member = new int[9];
			member[0] = Integer.parseInt(rs.getString("play1"));
			member[1] = Integer.parseInt(rs.getString("play2"));
			member[2] = Integer.parseInt(rs.getString("play3"));
			member[3] = Integer.parseInt(rs.getString("play4"));
			member[4] = Integer.parseInt(rs.getString("play5"));
			member[5] = Integer.parseInt(rs.getString("play6"));
			member[6] = Integer.parseInt(rs.getString("play7"));
			member[7] = Integer.parseInt(rs.getString("play8"));
			member[8] = Integer.parseInt(rs.getString("play9"));
			
	
			
			
			vo = new MemberVO( memberId, password, nick,  idCode,score, member);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
//--------------------------------------------------------------------------	
	
	
	
	
	
	
	
}
