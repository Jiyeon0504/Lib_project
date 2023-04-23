package kr.ac.kopo.book.ui;

import java.util.Scanner;

import kr.ac.kopo.member.ui.ILibraryUI;
import kr.ac.kopo.member.ui.LibraryModeUI;



public class bookManageUI extends LibraryModeUI {

	private int choice() {
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t   [도서관리]");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("메뉴를 선택하세요");

		System.out.println("1. 도서등록");
		System.out.println("2. 도서삭제");
		System.out.println("3. 대출현황");
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
				ui = new insertBookUI();
				ui.execute();
				break;

			case 2:
				ui = new deleteBookUI();
				ui.execute();

				break;
//
//			case 3:
//				ui = new nowBookUI();
//				ui.execute();
//
//				break;
				
			case 0:
				System.out.println("관리자모드 로그아웃 되었습니다");
				super.execute();
				break;
				
			}

		}
		
	}

}
