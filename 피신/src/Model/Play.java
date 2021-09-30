package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Play {

	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	PlayerDAO dao;
	double[] reportArr = new double[9];
	int[] scoreArr = new int[15];
	int score;
	int id = 1;
	int inning = 1;
	int sleep = 2000;
	double sbSucess = dao.outPutPlayer(id).getSb() / (dao.outPutPlayer(id).getSb() + dao.outPutPlayer(id).getSbf());

	
//		[0]	1타single율		//	[5]	사구hbp율
//		[1]	2타doubl율		//	[6]	삼진 so율
//		[2]	3타tirple율		//	[7]	병살gt율
//		[3]	홈런hr율			//	[8]	플라이아웃fo율
//		[4]	볼넷bb율			
	
	
//	{
//		reportArr[0] = 0.246515679;
//		reportArr[1] = 0.290069686;g
//		reportArr[2] = 0.290069686;
//		reportArr[3] = 0.320557491;
//		reportArr[4] = 0.415505226;
//		reportArr[5] = 0.430313589;
//		reportArr[6] = 0.492160279;
//		reportArr[7] = 0.535714286;
//		reportArr[8] = 1.0;
//	}

//	{
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
		try {
			int inningScore = 0;
			int out = 0;
			ArrayList<String> baseList = new ArrayList<>();
			baseList.add("◇");
			baseList.add("◇");
			baseList.add("◇");
			baseList.add("◇");

			while (out < 3) { // 한 회차분 회가 끝나면 베이스 상황 아웃카운트 리셋되야
				System.out.println();
				System.out.println(id + "번 타자" + " dao.outPutPlayer(id).getName()" + "선수 타석에 들어섭니다.");
				System.out.print("투수 와인드 업!");
				Thread.sleep(sleep);
//도루시작
				if (baseList.get(0).equals("◆") && baseList.get(1).equals("◇")) {

					System.out.print("\t\t도루 하시겠습니까? [1]시도 [2]포기");
					int sbChoice = sc.nextInt();

					if (sbChoice == 1) {
						boolean sbResult = sbSucess > ran.nextDouble() ? true : false;

					}

				}
//도루끝
				while (out < 3) { // 한 회차분 회가 끝나면 베이스 상황 아웃카운트 리셋되야
					System.out.println();
					System.out.println(id + "번 타자" + " dao.outPutPlayer(id).getName()" + "선수 타석에 들어섭니다.");
					System.out.print("투수 와인드 업!");
					Thread.sleep(sleep);
					System.out.println("\t\t던졌습니다!");
					Thread.sleep(sleep);

					System.out.println("\t\t던졌습니다!");
					Thread.sleep(sleep);

					int temp = 0;
					for (int i = 0; i < reportArr.length; i++) {
						if (reportArr[i] < ran.nextDouble()) {
							temp = i;
						}
					}

					switch (temp) {
					case 0, 4, 5:
						baseList.add(0, "◆");
						System.out.println("\t\t" + baseList.get(1) + "\t\t");
						System.out.println("\t\t\t\t\t쳤습니다!");
						System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t1루타");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						break;
					case 1:
						baseList.add(0, "◇");
						baseList.add(1, "◆");
						System.out.println("\t\t" + baseList.get(1) + "\t\t");
						System.out.println("\t\t\t\t\t쳤습니다!");
						System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t2루타");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						break;
					case 2:
						baseList.add(0, "◇");
						baseList.add(1, "◇");
						baseList.add(2, "◆");
						System.out.println("\t\t" + baseList.get(1) + "\t\t");
						System.out.println("\t\t\t\t\t쳤습니다!");
						System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t3루타");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						break;
					case 3:
						System.out.println(" | | | ||  _  ||  \\/  ||  ___| | ___ \\| | | || \\ | ||/\\/ | || |");
						System.out.println(" | |_| || | | || .  . || |__   | |_/ /| | | ||  \\| |     | || |");
						System.out.println(" |  _  || | | || |\\/| ||  __|  |    / | | | || . ` |     | || |");
						System.out.println(" | | | |\\ \\_/ /| |  | || |___  | |\\ \\ | |_| || |\\  |     |_||_|");
						System.out.println(" \\_| |_/ \\___/ \\_|  |_/\\____/  \\_| \\_| \\___/ \\_| \\_/     (_)(_)");
						baseList.add(0, "◇");
						baseList.add(1, "◇");
						baseList.add(2, "◇");
						baseList.add(3, "◆");
						System.out.println();
						System.out.println("\t\t" + baseList.get(1) + "\t\t쭉쭉 뻗어나가는 공~ 펜스를 넘습니다.!");
						System.out.println("\t\t\t\t\t홈런입니다. 모든 주자 홈으로~");
						System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t "
								+ " dao.outPutPlayer(id).getName()" + "선수 팬들을 향해 손을 흔들며 여유롭게 홈에 들어옵니다.");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						break;
					case 6:
						System.out.println("\t\t" + baseList.get(1) + "\t\t");
						System.out.println("\t\t\t\t\t스트라이크 아웃!");
						System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t감독표정이 안 좋은데요");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						out++;
						break;
					case 7:
						System.out.println("\t\t" + baseList.get(1) + "\t\t");
						System.out.println("\t\t\t\t\t쳤습니다! 높이 뜬 공~");
						System.out.println("\t" + baseList.get(2) + "\t\t" + baseList.get(0) + "\t\t외야수 처리합니다.");
						System.out.println();
						System.out.println("\t\t" + baseList.get(3) + "\t\t");
						out++;
						break;
					case 8:
						if (baseList.get(2).equals("◆")) {
							baseList.remove(2);
							baseList.add(2, "◇");
							System.out.println("\t\t" + baseList.get(1) + "\t\t쳤습니다! 짧게 떨어지는 공~3루수 바로 잡습니다. 3루주자 아웃");
							System.out.println("\t\t\t\t\t1루로 송구합니다. 1루주자 아웃! 병살타");
							System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t"
									+ " dao.outPutPlayer(id).getName()" + "선수 오늘 무언가가 잘 안 풀리는 듯한 모습");
							System.out.println();
							System.out.println("\t\t" + baseList.get(3) + "\t\t");
							out += 2;
						} else if (baseList.get(1).equals("◆")) {
							baseList.remove(1);
							baseList.add(1, "◇");
							System.out.println("\t\t" + baseList.get(1) + "\t\t빗맞은 타구! 투수 앞에 떨어집니다. 2루주자 아웃");
							System.out.println("\t\t\t\t\t1루로 송구합니다. 1루주자 아웃! 병살타");
							System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t"
									+ " dao.outPutPlayer(id).getName()" + "선수를 바라보는 벤치의 표정이 좋지가 않습니다");
							System.out.println();
							System.out.println("\t\t" + baseList.get(3) + "\t\t");
							out += 2;
						} else if (baseList.get(0).equals("◆")) {
							baseList.remove(0);
							baseList.add(0, "◇");
							System.out.println("\t\t" + baseList.get(1) + "\t\t1루수 바로 잡아 2루로 송구 2루주자 아웃");
							System.out.println("\t\t\t\t\t1루로 송구합니다. 이게 웬일입니까? 병살타가 나오고 맙니다.");
							System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t"
									+ " dao.outPutPlayer(id).getName()" + "선수 괜히 방망이에 화풀이를 하는군요");
							System.out.println();
							System.out.println("\t\t" + baseList.get(3) + "\t\t");
							out += 2;
						} else {
							System.out.println("\t\t" + baseList.get(1) + "\t\t");
							System.out.println("\t\t\t\t\t짧게 떨어진 공~ 내야수 바로 잡습니다.");
							System.out.println("\t" + baseList.get(3) + "\t\t" + baseList.get(0) + "\t\t1루로 송구~ 주자 아웃");
							System.out.println();
							System.out.println("\t\t" + baseList.get(3) + "\t\t");
							out++;
						}
						break;

					}

					// 주자 상황 구하기
					String base = "";
					int baseCounter = 0;
					for (int j = 0; j < 3; j++) {
						if (baseList.get(j).equals("◆")) {
							base += j + 1 + " ";
							baseCounter++;
						}
					}

					// 점수구하기
					inningScore = Collections.frequency(baseList, "◆") - baseCounter;
					scoreArr[inning - 1] = inningScore;
					scoreArr[inning - 1] = inningScore;
					score = 0;
					for (int i = 0; i < scoreArr.length; i++) {
						score += scoreArr[i];
					}

					System.out.println("     ___________     ______________       ______ ");
					System.out.printf("    ㅣ점수 : %2d점ㅣ    ㅣ주자 %6s루ㅣ      ㅣ%1d outㅣ\n", score, base, out);
					System.out.println("=======================================================");
					id = id < 9 ? id + 1 : 1;
					Thread.sleep(sleep);
					Thread.sleep(sleep);
				}
				Thread.sleep(sleep);
				System.out.println();
				System.out.println();
				System.out.printf("쓰리아웃 %s팀 %d점을 얻으며 총 %d점으로 %d회초 경기 마무리합니다.", "dao.outPutPlayer(id).getTeam()",
						scoreArr[inning - 1], score, inning);
				System.out.println();
				System.out.println();
				System.out.println("=======================================================");
				baseList.clear();
				inning++;
				Thread.sleep(sleep);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
