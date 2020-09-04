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
			System.out.println("번호를 입력해주세요");
			selnum = in.nextInt();
			in.nextLine();
			switch (selnum) {//
			case 1:
				docterlist();//모든 의사 보기
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
		System.out.println("1.모든 의사 보기");
		System.out.println("2.예약하기");
	}
}
