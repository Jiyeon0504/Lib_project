package kr.ac.kopo.member.ui;

import java.util.Scanner;

public class memManageUI extends LibraryModeUI {

	private int choice() {
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t   [회원관리]");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("메뉴를 선택하세요");

		System.out.println("1. 회원등록");
		System.out.println("2. 회원삭제");
//		System.out.println("3. [회원관리] 회원검색");
		System.out.println("0. 이전으로");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
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
				System.out.println("\t\t\t\t\t\t   *** 회원등록 ***");
				ui = new mJoin();
				ui.execute();
				
				break;
				
			case 2:
				System.out.println("\t\t\t\t\t\t   *** 회원삭제 ***");
				ui = new mQuit();
				ui.execute();
				break;
//				
//				
			case 0:
				super.execute();
				break;
				
		
	}

}
}
}
