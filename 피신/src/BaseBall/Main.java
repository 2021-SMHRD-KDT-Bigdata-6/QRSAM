package BaseBall;

import java.util.Scanner;



public class Main {
	// ȸ������ �ý���

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberVO mine;

		
		System.out.println("==================================================");
		System.out.println();
		System.out.println();
		System.out.println("\t\tBaseball   Game");
		System.out.println("\t\t  ������ : QR");
		System.out.println();
		System.out.println();
		System.out.println("==================================================");
		
		System.out.println();
		System.out.println();
		System.out.println("\t\t������ �����մϴ�! ");
		System.out.println("\t\t version 1.0 ");
		System.out.println();
		System.out.println();
		
		System.out.println("==================================================");
		boolean load = true;
		while(load) {
		
			System.out.println();
			System.out.println();
			System.out.println("\t\t �������ּ��� ");
			System.out.println("\t   1.�α��� 2.ȸ������ 3.���� ");
			System.out.print("\t\t>>  ");
			switch (sc.nextInt()) {
			case 1: 
				Membership memship = new Membership(); 
				//�����α��� ����
				System.out.println();
				System.out.println();
				System.out.println("==================================================");
				System.out.println();
				System.out.println();
				System.out.println("\t   ���̵�� ��й�ȣ�� �Է����ּ���!");
				MemberVO sample = new MemberVO();
				System.out.print("\t\t ���̵�: ");
				sample.setMemberId(sc.next());
				System.out.print("\t\t ��й�ȣ: ");
				sample.setPassword(sc.next());
				mine =memship.login(sample);
				if(mine == null) {
					break;
				}
				
				//�α��� ������
				System.out.println();
				System.out.println();
				System.out.println("==================================================");
				
				//�����̱�
				Membership memship3 = new Membership();
				MemberDAO Mdao3 = new MemberDAO();
				int choiceTime = 3;
				PlayerVO[] players = new PlayerVO[9];
				PlayerVO vo;
				int number;
				System.out.println();
				System.out.println();
				System.out.println("\t\t���� �̱⸦ �����մϴ�.");
				
				for(int i =0; i <9; i ++) {
					ChoicePlayer choiceP = new ChoicePlayer();
					System.out.println("\t\t���� ������ ��� �մϴ�.");
					System.out.println();
					System.out.println();
					System.out.println("==================================================");
					System.out.println();
					vo = choiceP.Choice();
					System.out.println();
					System.out.println("==================================================");
					System.out.println();
					System.out.println();
					System.out.println("\t\t������ �̰ڽ��ϱ�?");
					System.out.print("    1.��, �����մϴ� 2. �ƴ�, �ٸ� ���� 3.���� >> ");
					number = sc.nextInt();
					
					if(choiceTime == 0 && number ==2 ) {//2����ȸ ������
						System.out.println("\t   ���� �ٽ� ���⸦ �����ϼ̽��ϴ�.");
						System.out.println("\t   �ڵ����� ���� �ο� �մϴ�.");
						System.out.println();
						System.out.println();
						System.out.println("==================================================");
						System.out.println();
						System.out.println();
						
						number =1;
					}else {// ��ȸ ������ ���
						switch(number) {
						case 1:
							players[i] = vo;
							break;
						case 2:
							i--;
							choiceTime--;
							System.out.println("\t\t���� �ٽ� �̱� Ƚ�� :"+ choiceTime);
							System.out.println("\t\t�ٽ� ������ �̰ڽ��ϴ�.");
							System.out.println();
							System.out.println();
							System.out.println("==================================================");
							System.out.println();
							System.out.println();
							break;
						case 3:
							System.out.println("������ �����մϴ�.");
							load =false;
							break;
						}
						
					}
					
				
				}
				
				//�������� ���ϱ�
//				  - ��� ������ ����ϱ�
				System.out.println();
				System.out.println();
				System.out.println("==================================================");
				System.out.println();
				System.out.println();
				System.out.println("\t\t���� �����Դϴ�.");
				for(int i =0; i < 9; i++) {
					System.out.println((i+1) +"���� ���� >>");
					players[i].print();
				}
				System.out.println();
				System.out.println();
				System.out.println("==================================================");
				System.out.println();
				System.out.println();
//				   -Ÿ�ڼ������ϱ�
				System.out.println("\t   Ÿ�� ���� ������ �������ּ���!");
				
				PlayerVO[] players_sample = new PlayerVO[9];
				
//				 -�Է��� �ߺ��� ������
				int [] array = new int[9];
				for(int i =0; i<9; i++) {
					System.out.print((i+1)+ "���� Ÿ�ڹ�ȣ >> ");
					int num = sc.nextInt();
					while( num > 9 || num <1) {
						System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.(1~8���� ����)");
						System.out.print((i+1)+ "���� Ÿ�ڹ�ȣ >> ");
						num = sc.nextInt();
					}
	
					// �ߺ��ߴ��� Ȯ��
					for(int j =0; j < i; j++) {
						if(num == array[j]) {
							System.out.println("�̹� ������ ��������!");
							System.out.println("�ٽ� �Է����ּ���!");
							System.out.print((i+1)+ "���� Ÿ�ڹ�ȣ >> ");
							num  = sc.nextInt();
							while( num > 9 || num <1) {
								System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.(1~8���� ����)");
								System.out.print((i+1)+ "���� Ÿ�ڹ�ȣ >> ");
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
				System.out.println();
				System.out.println();
				
				players = players_sample;
				System.out.println("\t\tŸ�� �����Դϴ�. �����Դϴ�.");
				for(int i =0; i < 9; i++) {
					System.out.println((i+1) +"���� Ÿ�� >>");
					players[i].print();
				}
				
			
				
				
				//���ӽ���
				for(int i =0;i<3;i++) {
					System.out.print("1.���ӽ��� 2.���� 3.���ӷ� ���� 4.���� >> ");
					number = sc.nextInt();
					switch(number) {
					//1�� ���ӽ���
					case 1:
						//��Ȳ�� : ���̽���Ȳ, �ƿ�ī��Ʈ, ����Ÿ��
						//��������� ��Ȳ�ǿ� �ݿ��ǵ���
						//��Ȳ�� ���� ������� ���
						break;
					//2�� ����(���,��Ÿ,�ɷ�ġ��������)
					case 2:
						
						break;
					//���ӷ� ����
					case 3:
						System.out.println("������ Ÿ�ڿ� ��������� �ɷ�ġ ��\r\n"
								+ "\r\n"
								+ " Ÿ���� �ɷ�ġ-������ �ɷ�ġ \r\n"
								+ "\r\n"
								+ "--> Ȩ��: 50�̻�  ->  ��� ������ڵ��� Ȩ����(ex1������+3)\r\n"
								+ "\r\n"
								+ "--> 3��Ÿ 40 (Ÿ�ݴɷ� vs ���ɷ�)\r\n"
								+ "\r\n"
								+ "--> 2��Ÿ 20\r\n"
								+ "\r\n"
								+ "--> 1��Ÿ 10\r\n"
								+ "\r\n"
								+ "--> ��: -10~10\r\n"
								+ "\r\n"
								+ "--> ��Ʈ����ũ:-10�ʰ�"
								+ "\r\n"
								+ "3��ȹ��� ������ �¸��� ����ȴ�."
								+ "\r\n"
								+ "3ȸ���� 3���� ���������� ������ �й�� ������"
								+ "\r\n"
								+ "��ȸ�� ���������� �������� ����Ҽ� �ִ�."
								+ "\r\n"
								+ "���� �ǿ����� �������,�ɷ�ġ��������,��Ÿ�� ����Ҽ��ִ�."
								+ "\r\n"
								+ "1.������� : Ÿ�ݴɷ� ��� (3%) , �ַ�ɷ� ���   //���� 2����"
								+ "\r\n"
								+ "2.����Ÿ�� : �ɷ�ġ ���� �ֱ� (�ɷ�ġ  -10~ 10) //2��"
								+ "\r\n"
								+ "3.��Ÿ : ����x");
						break;
					//4�� ����
					case 4:
						System.out.println("������ �����մϴ�.");
						break;
					}
				
				
				break;
				}
				
				
				
				
				
				
				
				
				
				
			case 2:
				Membership memship2 = new Membership(); 
				MemberDAO Mdao2 = new MemberDAO();
				//ȸ�����԰���
				System.out.println();
				System.out.println();
				System.out.println("==================================================");
				System.out.println();
				System.out.println("\t   ���̵�� ��й�ȣ�� �Է����ּ���!");
				System.out.print("\t\t ���̵�: ");
				String memberId = sc.next();
				System.out.print("\t\t ��й�ȣ: ");
				String password = sc.next();
				System.out.print("\t\t �̸�: ");
				String nick = sc.next();
				System.out.println();
				
				MemberVO sample2 = new MemberVO(memberId,password,nick, "0", 0, new int[9]);
				if(memship2.Match(sample2)) {
					System.out.println("==================================================");
					System.out.println();
					System.out.println();
					System.out.println("\t\t ��... ���̵� �ֳ׿�! �ٽ�!");
					break;
				}
				//������ ������ȣ ����
				sample2.setIdCode(Integer.toString(Mdao2.count()+1));
				Mdao2.inPutMember(sample2);
				System.out.println("==================================================");
				System.out.println();
				System.out.println();
				System.out.println("\t\t ���̵� ����������ϴ�.");
				System.out.println("\t\t    ȯ���մϴ�! ^^");
				break;
				

			case 3:
				System.out.println();
				System.out.println();
				System.out.println("==================================================");
				System.out.println();
				System.out.println();
				System.out.println("\t     �̷�, �ƽ�����! �������ƿ�");
				System.out.println("\t\t      ��.��");
				System.out.println();
				System.out.println();
				System.out.println("==================================================");
				load =false;
				break;
				
			}	
			
		}
		sc.close();
		
	}
}

