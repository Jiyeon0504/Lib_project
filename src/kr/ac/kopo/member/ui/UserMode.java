package kr.ac.kopo.member.ui;

import java.util.Scanner;


public class UserMode extends LibraryModeUI {
	
//	private Memberservice memberService;
	
	private int choice() {
		System.out.println("---------------------------------------------------------------------------------------------------------------");

		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("0. 이전 화면");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("메뉴를 선택하세요");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();

		return choice;
	}

	@Override
	public void execute() throws Exception {
//
//		JoinUI join = new JoinUI();
//		LoginUI login = new LoginUI();
//		ILibraryUI ui =null;
		while (true) {
			int type = choice();
			ILibraryUI ui = null;

			switch (type) {
			case 1:
				ui = new JoinUI();
				ui.execute();
				
				
				break;
			
			
			case 2:
				ui = new LoginUI();
				ui.execute();
				
				break;
				
			case 0:
				super.execute();
				break;

			}
		}
	}
}
