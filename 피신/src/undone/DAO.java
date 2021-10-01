package undone;

import java.sql.ResultSet;
import java.sql.SQLException;

import BaseBall.MemberVO;
import BaseBall.PlayerVO;

public class DAO extends DAOHidden{
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

	public MemberVO outPutMember(int id) {
		MemberVO vo = null;
		getConn();
		String sql = "select * from Members where idCode = ?";
		ResultSet rs;
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

	

