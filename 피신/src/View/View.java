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
		System.out.println("====ȯ������====");

		// MainJointMember<<-ȯ������,�α���,ȸ������ ��������
		// ��Ʒ��� �ٿ��ֱ�

		// ��������
		while (temp) {
			// ȸ������,�α���,����
			System.out.print("1.�α��� 2.ȸ������ 3.���� >> ");
			number = sc.nextInt();
			switch (number) {
			// 1�� �α���
			case 1:
				temp = false;
				// �α��θ޼ҵ� �Է� ��
				System.out.println("���� ���� �̱�");
				// ���������̱�޼ҵ�
				// ����������� ���
				// ��������3ȸ����
				// ���̵� ���� ����ֱ�
				break;
			// 2�� ȸ������
			case 2:
				// ȸ�����Ը޼ҵ� �Է�
				break;
			case 3:
				System.out.println("������ �����մϴ�.");
				break;

			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�..!");
				System.out.println("�ٽ� �Է����ּ���.");
				break;
			}

		}

		for (int i = 0; i < 3; i++) {
			System.out.print("1.���ӽ��� 2.���� 3.���ӷ� ���� 4.���� >> ");
			number = sc.nextInt();
			switch (number) {
			// 1�� ���ӽ���
			case 1:
				p.play();
				break;
			// 2�� ����(���,��Ÿ,�ɷ�ġ��������)
			case 2:

				break;
			// ���ӷ� ����
			case 3:
				System.out.println("������ Ÿ�ڿ� ��������� �ɷ�ġ ��\r\n" + "\r\n" + " Ÿ���� �ɷ�ġ-������ �ɷ�ġ \r\n" + "\r\n"
						+ "--> Ȩ��: 50�̻�  ->  ��� ������ڵ��� Ȩ����(ex1������+3)\r\n" + "\r\n" + "--> 3��Ÿ 40 (Ÿ�ݴɷ� vs ���ɷ�)\r\n"
						+ "\r\n" + "--> 2��Ÿ 20\r\n" + "\r\n" + "--> 1��Ÿ 10\r\n" + "\r\n" + "--> ��: -10~10\r\n" + "\r\n"
						+ "--> ��Ʈ����ũ:-10�ʰ�" + "\r\n" + "3��ȹ��� ������ �¸��� ����ȴ�." + "\r\n" + "3ȸ���� 3���� ���������� ������ �й�� ������"
						+ "\r\n" + "��ȸ�� ���������� �������� ����Ҽ� �ִ�." + "\r\n" + "���� �ǿ����� �������,�ɷ�ġ��������,��Ÿ�� ����Ҽ��ִ�." + "\r\n"
						+ "1.������� : Ÿ�ݴɷ� ��� (3%) , �ַ�ɷ� ���   //���� 2����" + "\r\n"
						+ "2.����Ÿ�� : �ɷ�ġ ���� �ֱ� (�ɷ�ġ  -10~ 10) //2��" + "\r\n" + "3.��Ÿ : ����x");
				break;
			// 4�� ����
			case 4:
				System.out.println("������ �����մϴ�.");
				break;
			}

			System.out.println("1.�����̱� 2. 3.���� >> ");
			number = sc.nextInt();
			switch (number) {

			case 1:
				System.out.println("==���� ���� �̱�==");
				// �����̱�޼ҵ�
				break;
			case 2:

				break;
			case 3:
				System.out.println("������ �����մϴ�.");
				break;
			}

			
		}
	}
}
