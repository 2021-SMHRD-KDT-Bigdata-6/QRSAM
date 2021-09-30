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
					System.out.println("\t\t �α��� ����!");
					break;
				}else {
					System.out.println("\t\t��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					break;
				}
			}
			
		}
		//�α��� �����ϸ� ������, �ƴϸ� null ����� ����� ����.
		if(j == dao.count()+1) {
			System.out.println("\t   ���̵�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			System.out.println("\t\t �ٽ� �Է� ���ּ���.");
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
