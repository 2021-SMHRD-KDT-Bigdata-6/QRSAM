package BaseBall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private void getConn() {
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
	
	public void createMemberTable(MemberVO vo) { //[[회원관리테이블]]
		getConn();
		/*try {
			String sql  = "create table join (?id VARC, pw, name, team, score)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getNick());
			psmt.setString(4, vo.getIdCode());
			psmt.setString(5, vo.getScore());
			
			cnt = psmt.executeUpdate();*/
			
		 
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
	
	public boolean inPutMember(MemberVO member) {
		boolean cnt = true;

		getConn();
		try {
			String sql = "insert into Members values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getPassword());
			psmt.setString(3, member.getNick());
			psmt.setString(4, member.getIdCode());
			psmt.setInt(5, member.getScore());
			for(int i =6; i < 15; i++) {
				psmt.setInt(i, member.getMember()[i-6]);

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
	
	public MemberVO outPutMember(int id) {
		MemberVO vo = null;
		getConn();
		String sql = "select * from Members where idCode = ?";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(id));
			rs = psmt.executeQuery();
			rs.next();
			String memberId =rs.getString("memberid");
			String password =rs.getString("password");
			String nick = rs.getString("nick");
			String idCode = Integer.toString(rs.getInt("idCode"));
			int score = rs.getInt("score");
			int[] member = new int[9];
			member[0] = rs.getInt("play1");
			member[1] = rs.getInt("play2");
			member[2] = rs.getInt("play3");
			member[3] = rs.getInt("play4");
			member[4] = rs.getInt("play5");
			member[5] = rs.getInt("play6");
			member[6] = rs.getInt("play7");
			member[7] = rs.getInt("play8");
			member[8] = rs.getInt("play9");
			
	
			
			
			vo = new MemberVO( memberId, password, nick,  idCode,score, member);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close();
		}
		return vo;
	}
	public ArrayList<MemberVO> rank() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		getConn();
		String sql ="select memberid, nick, score "
				+ "from members "
				+ "order by score desc";
				
		try {
			psmt = conn.prepareStatement(sql);
			
			rs= psmt.executeQuery();
			
			while (rs.next()) {
				String memberId =rs.getString("memberid");
				
				String nick = rs.getString("nick");
				
				int score = rs.getInt("score");
				
				
				MemberVO  vo = new MemberVO(memberId, nick, score);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
		return list;
		
	}
	   public int outputscore(MemberVO vo) {
		      getConn();
		      int result = 0;
		      try {
		         String sql = "select score from members where id = ? ";
		  
		         psmt = conn.prepareStatement(sql);
		         rs = psmt.executeQuery();
		         rs.next();
		         result = rs.getInt("score");

		            
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return result;
		   }
		   //========================================================================
		   public void updatescore(int score, MemberVO vo) {
		      getConn();
		      try {
		         String sql = "update memebers set score = ? where id = ?";
		         psmt = conn.prepareStatement(sql);
		         psmt.setInt(1, score);
		         psmt.setString(2, vo.getMemberId());
		         
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		}
}
		   



