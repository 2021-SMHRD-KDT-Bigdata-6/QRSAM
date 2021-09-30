package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			String DB_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			
			
			String DB_ID = "cgi_5_3";
			String DB_Password = "smhrd3";
			
			conn = DriverManager.getConnection(DB_url, DB_ID, DB_Password);
			}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}catch(SQLException e) {
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
	
	
	public boolean inPutPlayer(PlayerVO player) {
		boolean cnt = true;

		getConn();
		try {
			String sql = "insert into BaseBallPlayer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, player.getId());
			psmt.setString(2, player.getName());
			psmt.setString(3, player.getTeam());
			psmt.setInt(4, player.getPa());
			psmt.setInt(5, player.getSingle());
			psmt.setInt(6, player.getDoubl());
			psmt.setInt(7, player.getTriple());
			psmt.setInt(8, player.getHr());
			psmt.setInt(9, player.getBb());
			psmt.setInt(10, player.getHbp());
			psmt.setInt(11, player.getSo());
			psmt.setInt(12, player.getGt());
			psmt.setInt(13, player.getFly());
			psmt.setInt(14, player.getSb());
			psmt.setInt(15, player.getSbf());
		
			psmt.executeUpdate();
		}catch (SQLException e) {
			cnt = false;
			e.printStackTrace();
		}finally {
			
			close();
		}
		return cnt;
	}
	
	
	public PlayerVO outPutPlayer(int id) {
		PlayerVO vo = null;
		getConn();
		String sql = "select * from BaseBallPlayer where id = ?";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(id));
			rs = psmt.executeQuery();
			rs.next();
			String id1 =rs.getString("id");
			String name =  rs.getString("name");
			String team = rs.getString("team");
			int pa = rs.getInt("pa");
			int single = rs.getInt("single");
			int doubl = rs.getInt("doubl");
			int triple = rs.getInt("triple");
			int hr = rs.getInt("hr");
			int bb = rs.getInt("bb");
			int hbp = rs.getInt("hbp");
			int so = rs.getInt("so");
			int gt = rs.getInt("gt");
			int fly = rs.getInt("fly");
			int sb = rs.getInt("sb");
			int sbf = rs.getInt("sbf");
	
			
			
			vo = new PlayerVO(id1, name,team, pa, single, doubl, triple, hr, bb,
					hbp, so, gt, fly, sb, sbf);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close();
		}
		return vo;
	}
}
