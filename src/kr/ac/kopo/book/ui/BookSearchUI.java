package kr.ac.kopo.book.ui;

import java.util.Scanner;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.member.ui.FoundationUI;
import kr.ac.kopo.member.ui.ILibraryUI;

public class BookSearchUI extends FoundationUI {

	private BookService service;

	private String title;
	private String writer;
	private String publisher;

	public BookSearchUI() {
		service = new BookService();

	}
	
private int choice() {
		
		System.out.println("1. 도서명으로 검색");
		System.out.println("2. 저자명으로 검색");
		System.out.println("3. ISBN으로 검색");
		System.out.println("0. 이전으로 돌아가기");
		
		
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
				ui = new TitleSearchUI();
				ui.execute();
				break;
			case 2:
				ui = new WriterSearchUI();
				ui.execute();
				
				break;
			case 3:
				ui = new IsbnSearchUI();
				ui.execute();
				
				break;
				
			case 0:
				ui = new BookMainUI();				
				ui.execute();
				break;
			}

		}
	}
}