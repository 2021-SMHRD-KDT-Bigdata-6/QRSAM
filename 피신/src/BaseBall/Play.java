package BaseBall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Play {

	protected Scanner sc = new Scanner(System.in);
	protected Random ran = new Random();
	protected PlayerVO[] players = new PlayerVO[9];
	
	protected double[][] reportArr = new double[9][9];
	protected MemberVO mine;
	
	Songs song = new Songs();

	
	public Play(PlayerVO[] players, MemberVO mine) {
		super();
		this.players = players;
		this.mine = mine;		
		for (int i = 0; i < 9; i++) {
			int all=players[i].getPa();
		
			reportArr[i][0] = players[i].getSingle()/(double)all;
			reportArr[i][1] = reportArr[i][0]+players[i].getDoubl()/(double)all;
			reportArr[i][2] = reportArr[i][1]+players[i].getTriple()/(double)all;
			reportArr[i][3] = reportArr[i][2]+players[i].getHr()/(double)all;
			reportArr[i][4] = reportArr[i][3]+players[i].getBb()/(double)all;
			reportArr[i][5] = reportArr[i][4]+players[i].getHbp()/(double)all;
			reportArr[i][6] = reportArr[i][5]+players[i].getSo()/(double)all;
			reportArr[i][7] = reportArr[i][6]+players[i].getGt()/(double)all;
			reportArr[i][8] = reportArr[i][6]+players[i].getFly()/(double)all;
		
		}
	
		
	}

	
	int[] scoreArr = new int[15];
	int score;
	int id = 0;
	int inning = 1;
	int sleep = 2000;
	double sbSuccess = 0.8;
//	double sbSuccess = dao.outPutPlayer(id).getSb() / (dao.outPutPlayer(id).getSb() + dao.outPutPlayer(id).getSbf());

//		[0]	1Ÿsingle��		//	[5]	�籸hbp��
//		[1]	2Ÿdoubl��		//	[6]	���� so��
//		[2]	3Ÿtirple��		//	[7]	����gt��
//		[3]	Ȩ��hr��			//	[8]	�ö��̾ƿ�fo��
//		[4]	����bb��	
	// i ���� ����. ���� reportArr[i][j[
//		reportArr[0] = dao.outPutPlayer(id).getSingle() / dao.outPutPlayer(id).getPa();
//		reportArr[1] = reportArr[0]+dao.outPutPlayer(id).getDoubl() / dao.outPutPlayer(id).getPa();
//		reportArr[2] = reportArr[1]+dao.outPutPlayer(id).getTriple() / dao.outPutPlayer(id).getPa();
//		reportArr[3] = reportArr[2]+dao.outPutPlayer(id).getHr() / dao.outPutPlayer(id).getPa();
//		reportArr[4] = reportArr[3]+dao.outPutPlayer(id).getBb() / dao.outPutPlayer(id).getPa();
//		reportArr[5] = reportArr[4]+dao.outPutPlayer(id).getHbp() / dao.outPutPlayer(id).getPa();
//		reportArr[6] = reportArr[5]+dao.outPutPlayer(id).getSo() / dao.outPutPlayer(id).getPa();
//		reportArr[7] = reportArr[6]+dao.outPutPlayer(id).getGt() / dao.outPutPlayer(id).getPa();
//		reportArr[8] = reportArr[7]+dao.outPutPlayer(id).getFly() / dao.outPutPlayer(id).getPa();
//		
//	}

	public void play() {

		int inningScore = 0;
		int out = 0;
		ArrayList<String> baseList = new ArrayList<>();
		baseList.add("��");
		baseList.add("��");
		baseList.add("��");
		baseList.add("��");

		try {
			song.play("�Լ�bgm");
			Thread.sleep(2000);
			while (out < 3) { // �� ȸ���� ȸ�� ������ ���̽� ��Ȳ �ƿ�ī��Ʈ ���µǾ�
				System.out.println();
				song.play("��Ʈbgm");
				Thread.sleep(500);
				System.out.println((id+1) + "�� Ÿ��" + players[id].getName() + " ���� Ÿ���� ���ϴ�.");
				System.out.print("���� ���ε� ��!");
				Thread.sleep(sleep);
				
//�������
				if (baseList.get(0).equals("��") && baseList.get(1).equals("��")) {

					System.out.print("\t\t���� �Ͻðڽ��ϱ�? [1]�õ� [2]����");
					int sbChoice = sc.nextInt();
					Thread.sleep(sleep);
					if (sbChoice == 1) {
						boolean sbResult = sbSuccess > ran.nextDouble() ? true : false;
						if (sbResult == true) {
							baseList.remove(1);
							baseList.add(0, "��");
							System.out.println("���� �� �� �Ĵ� ���� 1�� ���� 2��� ���� ����!");
						} else {
							out++;
							System.out.println("���� 2��� �޷������� ������� ĳġ�ϴ� ����, ������ �����մϴ�!");
						}
					} else {
						System.out.print("���� ������ ������ �ٽ� ���ε� ��!");
						System.out.println("\t\t�������ϴ�!");
						Thread.sleep(sleep);
						
					}
				} else {
					System.out.println("\t\t�������ϴ�!");
					Thread.sleep(sleep);
				}
//���糡
				
				//��Ÿ Ȯ�� �����
				
				int temp = 0;
				double probab = ran.nextDouble();
				for (int i = 0; i < reportArr[id].length; i++) {
					if (reportArr[id][i] < probab) {
						temp = i;
					}
				}

				
				
				//��Ÿ ����~
				song.play("��Ʈbgm");
				switch (temp) {
				case 0, 4, 5:
					baseList.add(0, "��");
					System.out.println("\t\t" + baseList.get(1) + "\t\t");
					System.out.println("\t\t\t\t\t�ƽ��ϴ�!");
					System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t1��Ÿ");
					System.out.println();
					System.out.println("\t\t" + baseList.get(3) + "\t\t");
					break;
				case 1:
					baseList.add(0, "��");
					baseList.add(1, "��");
					System.out.println("\t\t" + baseList.get(1) + "\t\t");
					System.out.println("\t\t\t\t\t�ƽ��ϴ�!");
					System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t2��Ÿ");
					System.out.println();
					System.out.println("\t\t" + baseList.get(3) + "\t\t");
					break;
				case 2:
					baseList.add(0, "��");
					baseList.add(1, "��");
					baseList.add(2, "��");
					System.out.println("\t\t" + baseList.get(1) + "\t\t");
					System.out.println("\t\t\t\t\t�ƽ��ϴ�!");
					System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t3��Ÿ");
					System.out.println();
					System.out.println("\t\t" + baseList.get(3) + "\t\t");
					break;
				case 3:
					song.play("�Լ�bgm");
					System.out.println(" | | | ||  _  ||  \\/  ||  ___| | ___ \\| | | || \\ | ||/\\/ | || |");
					System.out.println(" | |_| || | | || .  . || |__   | |_/ /| | | ||  \\| |     | || |");
					System.out.println(" |  _  || | | || |\\/| ||  __|  |    / | | | || . ` |     | || |");
					System.out.println(" | | | |\\ \\_/ /| |  | || |___  | |\\ \\ | |_| || |\\  |     |_||_|");
					System.out.println(" \\_| |_/ \\___/ \\_|  |_/\\____/  \\_| \\_| \\___/ \\_| \\_/     (_)(_)");
					baseList.add(0, "��");
					baseList.add(1, "��");
					baseList.add(2, "��");
					baseList.add(3, "��");
					System.out.println();
					System.out.println("\t\t" + baseList.get(1) + "\t\t���� ������� ��~ �潺�� �ѽ��ϴ�.!");
					System.out.println("\t\t\t\t\tȨ���Դϴ�. ��� ���� Ȩ����~");
					System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t "
							+ players[id].getName()+ " ���� �ҵ��� ���� ���� ���� �����Ӱ� Ȩ�� ���ɴϴ�.");
					System.out.println();
					System.out.println("\t\t" + baseList.get(3) + "\t\t");
					break;
				case 6:
					System.out.println("\t\t" + baseList.get(1) + "\t\t");
					System.out.println("\t\t\t\t\t��Ʈ����ũ �ƿ�!");
					System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t����ǥ���� �� ��������");
					System.out.println();
					System.out.println("\t\t" + baseList.get(3) + "\t\t");
					out++;
					break;
				case 7:
					System.out.println("\t\t" + baseList.get(1) + "\t\t");
					System.out.println("\t\t\t\t\t�ƽ��ϴ�! ���� �� ��~");
					System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t�ܾ߼� ó���մϴ�.");
					System.out.println();
					System.out.println("\t\t" + baseList.get(3) + "\t\t");
					out++;
					break;
				case 8:
					if (baseList.get(2).equals("��")) {
						baseList.remove(2);
						baseList.add(2, "��");
						System.out.println("\t\t" + baseList.get(1) + "\t\t�ƽ��ϴ�! ª�� �������� ��~3��� �ٷ� ����ϴ�. 3������ �ƿ�");
						System.out.println("\t\t\t\t\t1��� �۱��մϴ�. 1������ �ƿ�! ����Ÿ");
						System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t"
								+ players[id].getName() + " ���� ���� ���𰡰� �� �� Ǯ���� ���� ���");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						out += 2;
					} else if (baseList.get(1).equals("��")) {
						baseList.remove(1);
						baseList.add(1, "��");
						System.out.println("\t\t" + baseList.get(1) + "\t\t������ Ÿ��! ���� �տ� �������ϴ�. 2������ �ƿ�");
						System.out.println("\t\t\t\t\t1��� �۱��մϴ�. 1������ �ƿ�! ����Ÿ");
						System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t"
								+ players[id].getName() + " ������ �ٶ󺸴� ��ġ�� ǥ���� ������ �ʽ��ϴ�");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						out += 2;
					} else if (baseList.get(0).equals("��")) {
						baseList.remove(0);
						baseList.add(0, "��");
						System.out.println("\t\t" + baseList.get(1) + "\t\t1��� �ٷ� ��� 2��� �۱� 2������ �ƿ�");
						System.out.println("\t\t\t\t\t1��� �۱��մϴ�. �̰� �����Դϱ�? ����Ÿ�� ������ ���ϴ�.");
						System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t"
								+ players[id].getName() + " ���� ���� ����̿� ȭǮ�̸� �ϴ±���");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						out += 2;
					} else {
						System.out.println("\t\t" + baseList.get(1) + "\t\t");
						System.out.println("\t\t\t\t\tª�� ������ ��~ ���߼� �ٷ� ����ϴ�.");
						System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t1��� �۱�~ ���� �ƿ�");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						out++;
					}
					break;

				}

				// ���� ��Ȳ ���ϱ�
				String base = "";
				int baseCounter = 0;
				for (int j = 0; j < 3; j++) {
					if (baseList.get(j).equals("��")) {
						base += j + 1 + " ";
						baseCounter++;
					}
				}

				// �������ϱ�
				inningScore = Collections.frequency(baseList, "��") - baseCounter;
				scoreArr[inning - 1] = inningScore;
				scoreArr[inning - 1] = inningScore;
				score = 0;
				for (int i = 0; i < scoreArr.length; i++) {
					score += scoreArr[i];
				}

				System.out.println("     ___________     ______________       ______ ");
				System.out.printf("    ������ : %2d����    ������ %6s���      ��%1d out��\n", score, base, out);
				System.out.println("=======================================================");
				id = (id < 8 ? id + 1 : 0);
				Thread.sleep(sleep);
				Thread.sleep(sleep);
			}
			System.out.println();
			System.out.println();
			song.play("�Լ�bgm");
			System.out.printf("�����ƿ� %s�� %d���� ������ �� %d������ %dȸ�� ��� �������մϴ�.", mine.getNick(),
					scoreArr[inning - 1], score, inning);
			System.out.println();
			System.out.println();
			System.out.println("=======================================================");
			baseList.clear();
			inning++;

			Thread.sleep(sleep);
		} catch (

		InterruptedException e) {
			e.printStackTrace();
		}

	}
}
