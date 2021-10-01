package BaseBall;

import java.util.Scanner;




public class Main {
	// 회원가입 시스템

	public static void main(String[] args) {
		
		Songs song = new Songs();
		
		
		try {
			song.play("Song1");
			Scanner sc = new Scanner(System.in);
			MemberVO mine;
			int sleep =1500;
		
			System.out.println("==================================================");
			System.out.println();
			System.out.println();
			System.out.println("\t\tBaseball   Game");
			System.out.println("\t\t  제작팀 : QR");
			System.out.println();
			System.out.println();
			System.out.println("==================================================");
			Thread.sleep(sleep);
			System.out.println();
			System.out.println();
			System.out.println("\t\t게임을 시작합니다! ");
			System.out.println("\t\t version 1.0 ");
			System.out.println();
			System.out.println();
		
			System.out.println("==================================================");
			Thread.sleep(sleep);
			boolean load = true;
			while(load) {
		
				System.out.println();
				System.out.println();
				System.out.println("\t\t 선택해주세요 ");
				System.out.println("\t   1.로그인 2.회원가입 3.종료 ");
				System.out.print("\t\t>>  ");
				switch (sc. nextInt()) {
				case 1: 
					Membership memship = new Membership(); 
					//계정로그인 과정
					System.out.println();
					System.out.println();
					System.out.println("==================================================");
					System.out.println();
					System.out.println();
					System.out.println("\t   아이디와 비밀번호를 입력해주세요!");
					MemberVO sample = new MemberVO();
					System.out.print("\t\t 아이디: ");
					sample.setMemberId(sc.next());
					System.out.print("\t\t 비밀번호: ");
					sample.setPassword(sc.next());
					mine =memship.login(sample);
					if(mine == null) {
						break;
					}
					boolean control =true;
					while(control) {
						control =false;
					//로그인 성공시
						System.out.println();
						System.out.println();
						System.out.println("==================================================");
						Thread.sleep(sleep);
					//선수뽑기
						Membership memship3 = new Membership();
						MemberDAO Mdao3 = new MemberDAO();
						int choiceTime = 3;
						PlayerVO[] players = new PlayerVO[9];
						PlayerVO vo;
						int number;
						System.out.println();
						System.out.println();
						System.out.println("\t\t선수 뽑기를 시작합니다.");
					
						for(int i =0; i <9; i ++) {
							ChoicePlayer choiceP = new ChoicePlayer();
							System.out.println("\t\t선수 정보를 출력 합니다.");
							System.out.println();
							System.out.println();
							System.out.println("==================================================");
							Thread.sleep(sleep-500);
							System.out.println();
							vo = choiceP.Choice();
							System.out.println();
							System.out.println("==================================================");
							Thread.sleep(sleep-500);
							System.out.println();
							System.out.println();
							System.out.println("\t\t선수를 뽑겠습니까?");
							System.out.print("    1.네, 결정합니다 2. 아뇨, 다른 선수 3.종료 >> ");
							number = sc.nextInt();
						
							if(choiceTime == 0 && number ==2 ) {//2번기회 소진시
								System.out.println("\t   선수 다시 보기를 소진하셨습니다.");
								System.out.println("\t   자동으로 선수 부여 합니다.");
								System.out.println();
								System.out.println();
								System.out.println("==================================================");
								Thread.sleep(sleep-500);
								System.out.println();
								System.out.println();
							
								number =1;
							}
						// 기회 남았을 경우
							switch(number) {
							case 1:
								players[i] = vo;
								break;
							case 2:
								i--;
								choiceTime--;
								System.out.println("\t\t선수 다시 뽑기 횟수 :"+ choiceTime);
								System.out.println("\t\t다시 선수를 뽑겠습니다.");
								System.out.println();
								System.out.println();
								System.out.println("==================================================");
								Thread.sleep(sleep-500);
								System.out.println();
								System.out.println();
								break;
							case 3:
								Thread.sleep(sleep-500);
								System.out.println("게임을 종료합니다.");
								System.exit(0);
								break;
							
							
							}
						}
						
					
					
					
					//선수순서 정하기
//					  - 모든 선수들 출력하기
						System.out.println();
						System.out.println();
						System.out.println("==================================================");
						Thread.sleep(sleep-500);
						System.out.println();
						System.out.println();
						System.out.println("\t\t뽑힌 선수입니다.");
						for(int i =0; i < 9; i++) {
							System.out.println((i+1) +"번쨰 선수 >>");
							players[i].print();
						}
						System.out.println();
						System.out.println();
						System.out.println("==================================================");
						Thread.sleep(sleep-500);
						System.out.println();
						System.out.println();
//					   -타자선수정하기
						System.out.println("\t   타자 선수 순서를 결정해주세요!");
					
						PlayerVO[] players_sample = new PlayerVO[9];
					
//					 -입력한 중복수 없에기
						int [] array = new int[9];
						for(int i =0; i<9; i++) {
							System.out.print((i+1)+ "번쨰 타자번호 >> ");
							int num = sc.nextInt();
							while( num > 9 || num <1) {
								System.out.println("잘못된 수를 입력하셨습니다.(1~8사이 선택)");
								System.out.print((i+1)+ "번쨰 타자번호 >> ");
								num = sc.nextInt();
							}
		
						// 중복했는지 확인
							for(int j =0; j < i; j++) {
								if(num == array[j]) {
									System.out.println("이미 선택한 선수군요!");
									System.out.println("다시 입력해주세요!");
									System.out.print((i+1)+ "번쨰 타자번호 >> ");
									num  = sc.nextInt();
									while( num > 9 || num <1) {
										System.out.println("잘못된 수를 입력하셨습니다.(1~8사이 선택)");
										System.out.print((i+1)+ "번쨰 타자번호 >> ");
										num = sc.nextInt();
									}
									j=-1;
								}
							
							}
							array[i]= num;
							players_sample[i]= players[num-1];
						
						}
					
						System.out.println();
						System.out.println();
						System.out.println("==================================================");
						Thread.sleep(sleep-500);
						System.out.println();
						System.out.println();
					
						players = players_sample;
						System.out.println("\t\t타자 순서입니다. 선수입니다.");
						for(int i =0; i < 9; i++) {
							System.out.println((i+1) +"번쨰 타자 >>");
							players[i].print();
						}
					
					
						System.out.println();
						System.out.println();
						System.out.println("==================================================");
					
						
						boolean load2 = true;
						
						//게임실행
						while(load2) {
							Thread.sleep(sleep-500);
							System.out.println();
							System.out.println();
							System.out.print("1.게임실행 2.감독 3.게임룰 설명 4.종료 >> ");
							number = sc.nextInt();
							System.out.println();
							System.out.println();
							System.out.println("==================================================");
							switch(number) {
						//1번 게임실행
							case 1:
								Play gamePlay = new Play(players, mine);
								gamePlay.play();
							//현황판 : 베이스상황, 아웃카운트, 현재타자
							//스윙결과가 현황판에 반영되도록
							//현황판 옆에 스윙결과 출력
			
								Thread.sleep(sleep-500);
								System.out.println();
								System.out.println();
								System.out.println("한판 더 할 건가요?");
								System.out.print("1.Yes 2. NO >> ");
								if(sc.nextInt()==1) {
									System.out.println("선수부터 다시 뽑겠습니까?");
									System.out.println("1.Yes 2. NO >> ");
									if(sc.nextInt()==1) {
										load2 = false;
										control =true;
										break;
									}else break;
								}else load2 =false;
							
								break;
						//2번 감독(장비,대타,능력치랜덤버프)
							case 2:
							
								break;
						//게임룰 설명
							case 3:
								Thread.sleep(sleep-500);
								System.out.println("선택한 타자와 상대투수의 능력치 비교\r\n"
									+ "\r\n"
									+ " 타자의 능력치-투수의 능력치 \r\n"
									+ "\r\n"
									+ "--> 홈런: 50이상  ->  모든 출루주자들이 홈으로(ex1루주자+3)\r\n"
									+ "\r\n"
									+ "--> 3루타 40 (타격능력 vs 방어능력)\r\n"
									+ "\r\n"
									+ "--> 2루타 20\r\n"
									+ "\r\n"
									+ "--> 1루타 10\r\n"
									+ "\r\n"
									+ "--> 볼: -10~10\r\n"
									+ "\r\n"
									+ "--> 스트라이크:-10초과"
									+ "\r\n"
									+ "3점획득시 게임은 승리로 종료된다."
									+ "\r\n"
									+ "3회동안 3점이 되지않으면 게임은 패배로 끝난다"
									+ "\r\n"
									+ "한회가 끝날때마다 감독탭을 사용할수 있다."
									+ "\r\n"
									+ "감독 탭에서는 장비장착,능력치랜덤버프,대타를 사용할수있다."
									+ "\r\n"
									+ "1.장비장착 : 타격능력 향상 (3%) , 주루능력 향상   //각각 2개씩"
									+ "\r\n"
									+ "2.작전타임 : 능력치 랜덤 주기 (능력치  -10~ 10) //2번"
									+ "\r\n"
									+ "3.대타 : 구현x");
								break;
						//4번 종료
							case 4:
								Thread.sleep(sleep-500);
								System.out.println();
								System.out.println();
								System.out.println("게임을 종료합니다.");
								System.out.println();
								System.out.println();
								System.out.println("==================================================");
								
								System.exit(0);
								break;
							}
						}
					}
					System.out.println("==================================================");
					System.out.println();
					System.out.println();
					Thread.sleep(sleep-500);
					System.out.println("게임을 종료합니다.");
					System.out.println();
					System.out.println();
					System.out.println("==================================================");
					
					
					load =false;
					break;
		
		
				
				case 2:
					Membership memship2 = new Membership(); 
					MemberDAO Mdao2 = new MemberDAO();
				//회원가입과정
					System.out.println();
					System.out.println();
					System.out.println("==================================================");
					System.out.println();
					System.out.println("\t   아이디와 비밀번호를 입력해주세요!");
					System.out.print("\t\t 아이디: ");
					String memberId = sc.next();
					System.out.print("\t\t 비밀번호: ");
					String password = sc.next();
					System.out.print("\t\t 이름: ");
					String nick = sc.next();
					System.out.println();
				
					MemberVO sample2 = new MemberVO(memberId,password,nick, "0", 0, new int[9]);
					if(memship2.Match(sample2)) {
						System.out.println("==================================================");
						System.out.println();
						System.out.println();
						System.out.println("\t\t 헐... 아이디가 있네요! 다시!");
						break;
					}
				//없으면 고유번호 지급
					sample2.setIdCode(Integer.toString(Mdao2.count()+1));
					Mdao2.inPutMember(sample2);
					System.out.println("==================================================");
					System.out.println();
					System.out.println();
					System.out.println("\t\t 아이디가 만들어졌습니다.");
					System.out.println("\t\t    환영합니다! ^^");
					break;
				

				case 3:
					System.out.println();
					System.out.println();
					System.out.println("==================================================");
					System.out.println();
					System.out.println();
					System.out.println("\t     이런, 아쉽군요! 다음에뵈요");
					System.out.println("\t\t      ㅜ.ㅜ");
					System.out.println();
					System.out.println();
					System.out.println("==================================================");
					load =false;
					System.exit(0);
					break;
				}
		
				
			}
			sc.close();
		}catch (InterruptedException e) {
					e.printStackTrace();
		}
		System.out.println("==================================================");
		System.out.println();
		System.out.println();
		System.out.println("\t     한 달 동안 수고 하셨습니다.");
		System.out.println("\t  제작자 김성광, 김진웅, 정유진, 전병만");
		System.out.println();
		System.out.println();
		System.out.println("==================================================");
		System.out.println();
		System.out.println();
		System.out.println("\t     도와주신 분: 김운비 선생님");
		System.out.println("\t\t 협찬: 스마트인재개발원");
		System.out.println();
		System.out.println();
		System.out.println("==================================================");
		
		
	}
}
			