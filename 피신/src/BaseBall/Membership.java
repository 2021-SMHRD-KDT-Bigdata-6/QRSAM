package BaseBall;


public class Membership {
	private MemberDAO dao = new MemberDAO();
	
	public boolean join(MemberVO vo) {
		return dao.inPutMember(vo);
	}
	
	
	public MemberVO login(MemberVO vo) {
		String id = vo.getMemberId();
		String password = vo.getPassword();
		MemberVO result = null;
		int j = 1;
		for(; j < dao.count()+1; j++) {
			MemberVO Compare = dao.outPutMember(j);
			if(Compare.getMemberId().equals(id)) {
				if(Compare.getPassword().equals(password)) {
					result = Compare;
					System.out.println("\t\t 로그인 성공!");
					break;
				}else {
					System.out.println("\t\t비밀번호가 틀렸습니다.");
					break;
				}
			}
			
		}
		//로그인 성공하면 정보가, 아니면 null 결과를 만들어 낸다.
		if(j == dao.count()+1) {
			System.out.println("\t   아이디와 비밀번호가 틀렸습니다.");
			System.out.println("\t\t 다시 입력 해주세요.");
		}
		return result;
		
	}
	
	
	
	public boolean Match(MemberVO vo) {
		boolean result = false;
		int i = dao.count();
		
		for(int j = 1; j < i+1; j++) {
			MemberVO Compare = dao.outPutMember(j);
			if(Compare.getMemberId().equals(vo.getMemberId())) {
				result = true;
			}
		}	
		return result;
	}

}
