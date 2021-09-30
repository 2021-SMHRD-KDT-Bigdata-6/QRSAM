package Model;

public class MemberVO {
	private String memberId;
	private String password;
	private String nick;
	private String idCode;
	private int score;
	private int[] member= new int[9];
	// play1, play2, play3, play4,play5,play6,play7,play8, play9 ∑Œ ¿˙¿Â
	
	
	public MemberVO(String memberId, String password, String nick, String idCode, int score, int[] member) {
		this.memberId = memberId;
		this.password = password;
		this.nick = nick;
		this.idCode = idCode;
		this.score = score;
		this.member = member;
	}
	
	public MemberVO() {
		
	}

	


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int[] getMember() {
		return member;
	}

	public void setMember(int[] member) {
		this.member = member;
	}
	
	
	
	

}
