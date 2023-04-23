package kr.ac.kopo.member.ui;

import java.util.Scanner;

public class LibraryModeUI extends FoundationUI {

	private int menu() {
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t *** 도서관리시스템 ***");
		System.out.println(" 1. 일반회원");
		System.out.println(" 2. 관리자");
		System.out.println("---------------------------------------------------------------------------------------------------------------");

		System.out.print("사용자 유형을 선택하세요: ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();

		return type;
	}

	@Override
	public void execute() throws Exception {
		
		while (true) {
			int type = menu();
			ILibraryUI ui = null;
			switch (type) {
			case 1:
				System.out.println("\t\t\t\t\t\t   *** 회원 모드 ***");
				ui = new UserMode();
				ui.execute();
				
				break;
				
			case 2:
				System.out.println("\t\t\t\t\t\t  *** 관리자 모드 ***");
				ui = new ManagerLogin();
				ui.execute();
				break;
				
				
			case 0:
				ui = new ExitUI();
				
				
				
				
				
				
			}

		}
	}
}
