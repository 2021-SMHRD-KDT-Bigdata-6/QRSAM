package View;

import java.util.Scanner;

import Model.MemberDAO;
import Model.MemberVO;
import Model.Membership;
import Model.Play;

public class View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Play p = new Play();
		MemberVO mine;
		Membership memship = new Membership();
		MemberDAO Mdao = new MemberDAO();
		int number;
		boolean temp = true;
		System.out.println("====환영문구====");

		// MainJointMember<<-환영문구,로그인,회원가입 가져오기
		// ↓아래에 붙여넣기

		// ↓지우면됨
		while (temp) {
			// 회원가입,로그인,종료
			System.out.print("1.로그인 2.회원가입 3.종료 >> ");
			number = sc.nextInt();
			switch (number) {
			// 1번 로그인
			case 1:
				temp = false;
				// 로그인메소드 입력 후
				System.out.println("랜덤 선수 뽑기");
				// 랜덤선수뽑기메소드
				// 랜덤선수멤버 출력
				// 선수거절3회가능
				// 아이디에 선수 집어넣기
				break;
			// 2번 회원가입
			case 2:
				// 회원가입메소드 입력
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				break;

			default:
				System.out.println("잘못입력하셨습니다..!");
				System.out.println("다시 입력해주세요.");
				break;
			}

		}

		for (int i = 0; i < 3; i++) {
			System.out.print("1.게임실행 2.감독 3.게임룰 설명 4.종료 >> ");
			number = sc.nextInt();
			switch (number) {
			// 1번 게임실행
			case 1:
				p.play();
				break;
			// 2번 감독(장비,대타,능력치랜덤버프)
			case 2:

				break;
			// 게임룰 설명
			case 3:
				System.out.println("선택한 타자와 상대투수의 능력치 비교\r\n" + "\r\n" + " 타자의 능력치-투수의 능력치 \r\n" + "\r\n"
						+ "--> 홈런: 50이상  ->  모든 출루주자들이 홈으로(ex1루주자+3)\r\n" + "\r\n" + "--> 3루타 40 (타격능력 vs 방어능력)\r\n"
						+ "\r\n" + "--> 2루타 20\r\n" + "\r\n" + "--> 1루타 10\r\n" + "\r\n" + "--> 볼: -10~10\r\n" + "\r\n"
						+ "--> 스트라이크:-10초과" + "\r\n" + "3점획득시 게임은 승리로 종료된다." + "\r\n" + "3회동안 3점이 되지않으면 게임은 패배로 끝난다"
						+ "\r\n" + "한회가 끝날때마다 감독탭을 사용할수 있다." + "\r\n" + "감독 탭에서는 장비장착,능력치랜덤버프,대타를 사용할수있다." + "\r\n"
						+ "1.장비장착 : 타격능력 향상 (3%) , 주루능력 향상   //각각 2개씩" + "\r\n"
						+ "2.작전타임 : 능력치 랜덤 주기 (능력치  -10~ 10) //2번" + "\r\n" + "3.대타 : 구현x");
				break;
			// 4번 종료
			case 4:
				System.out.println("게임을 종료합니다.");
				break;
			}

			System.out.println("1.선수뽑기 2. 3.종료 >> ");
			number = sc.nextInt();
			switch (number) {

			case 1:
				System.out.println("==랜덤 선수 뽑기==");
				// 선수뽑기메소드
				break;
			case 2:

				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				break;
			}

			
		}
	}
}
