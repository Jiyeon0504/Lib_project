package kr.ac.kopo.book.ui;

import java.util.Scanner;

import kr.ac.kopo.member.ui.ILibraryUI;
import kr.ac.kopo.member.ui.LibraryModeUI;
import kr.ac.kopo.member.ui.Personal;

public class BookMainUI extends LibraryModeUI {
	
	
	private int choice() {
//		System.out.println("---------------------------------------------------------------------------------------------------------------");
//		System.out.println("\t\t\t\t\t\t    ["+LoginUI.getLoginId()+"님 환영합니다]");
//		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("메뉴를 선택하세요");
		
		System.out.println("1. 전체 도서 목록");
		System.out.println("2. 도서검색 ");
		System.out.println("3. 도서대여 ");
		System.out.println("4. 도서반납 ");
		System.out.println("5. 마이메이지");
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
				ui = new searchAllUI();
				break;
			
			case 2:
				ui = new BookSearchUI();
				break;
				
			
			case 3:
				ui = new BookRentUI();
				break;
				
				
			case 4:
				ui = new BookReturnUI();
				
				break;
				
			case 5:
				ui = new Personal();
				break;
				
				
			case 0:
				
			System.out.println("로그아웃 되었습니다");
			System.out.println("감사합니다");
				super.execute();
				break;
			
				
			}
			if (ui != null) {
				ui.execute();
				
			}else {
				System.out.println("잘못입력하셨습니다");
			}
		
	}

	
	
	
	}	
}
