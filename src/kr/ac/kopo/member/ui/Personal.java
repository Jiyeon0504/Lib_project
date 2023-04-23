package kr.ac.kopo.member.ui;

import java.util.Scanner;

import kr.ac.kopo.book.ui.BookMainUI;
import kr.ac.kopo.book.ui.viewPersonal;


public class Personal extends FoundationUI {
	
	
	private int choice() {
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t   ["+LoginUI.getLoginId()+"님 마이페이지]");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
//		System.out.println(LoginUI.getLoginId());
		System.out.println("1. 내 정보 확인");
		System.out.println("2. 내 정보 변경");
		System.out.println("3. 대출목록 조회");
		System.out.println("4. 회원탈퇴");
		System.out.println("0. 이전으로");

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
					ui = new viewPersonal();
					ui.execute();
					break;

				case 2:
					ui = new mQuit();
					ui.execute();

					break;
					
				case 3: 
					
					break;
					
				case 4:
					
					ui = new mQuit();
					ui.execute();
					
					break;
					
				case 0:
					BookMainUI mui = new BookMainUI();
					mui.execute();
					break;
					

				}

			}
		}

	}
