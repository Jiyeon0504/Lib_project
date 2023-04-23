package kr.ac.kopo.member.ui;

import java.util.Scanner;

import kr.ac.kopo.book.ui.bookManageUI;

public class ManagerMode extends LibraryModeUI {


	private int choice() {
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("메뉴를 선택하세요");

		System.out.println("1. 회원관리");
		System.out.println("2. 도서관리");
		System.out.println("9. 프로그램 종료");
		System.out.println("0. 로그아웃");
		
		

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();

		return choice;
	}

	@Override
	public void execute() throws Exception {

		while (true) {
			int type = choice();
			ILibraryUI ui = null;

			switch (type) {
			case 1:
				ui = new memManageUI();
				ui.execute();
				break;

			case 2:
				ui = new bookManageUI();
				ui.execute();
				
			case 3: 
				ui = new ExitUI();
				ui.execute();
				break;
		
			case 0:
				super.execute();
				break;

			}

		}
	}
}
