package BaseBall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Rank {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	MemberDAO dao = new MemberDAO();
	
	
	public ArrayList<MemberVO> Rank() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		
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
	

}
