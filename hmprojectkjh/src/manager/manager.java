package manager;

import java.util.Scanner;

import DBinterface.serviceimple;

public class manager {
	private Scanner in = new Scanner(System.in);
	private serviceimple serv = new serviceimple();

	public manager() {
		int selnum = -1;
		while (true) {
			menu();
			System.out.println("��ȣ�� �Է����ּ���");
			selnum = in.nextInt();
			in.nextLine();
			switch (selnum) {//
			case 1:
				docterlist();//��� �ǻ� ����
				break;
			case 2:
				promiss();
				break;
			default:
			}
		}
	}

	private void promiss() {

		serv.promiss();

	}

	private void docterlist() {
		serv.list();

	}

	private void menu() {
		System.out.println("1.��� �ǻ� ����");
		System.out.println("2.�����ϱ�");
	}
}
