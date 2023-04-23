package kr.ac.kopo.book.ui;

import java.util.Scanner;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.book.service.bookServiceFactory;
import kr.ac.kopo.book.vo.rentBookVO;
import kr.ac.kopo.member.ui.FoundationUI;
import kr.ac.kopo.member.ui.LoginUI;


public class BookRentUI extends FoundationUI {

	private BookService bookService;

	public BookRentUI() {
		bookService = bookServiceFactory.getInstance();
	}
	@Override
	public void execute() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("책번호를 입력하세요: "); 
		int no = sc.nextInt(); 
		
		rentBookVO book = new rentBookVO();
		
		book.setBookNo(no);
		book.setUserID(LoginUI.getLoginId());
		
		bookService.rentBook(book);
		
		
		
		System.out.println(book.getBookName());
		System.out.println("대출이 완료되었습니다");
		System.out.println();
		
		BookMainUI ui = new BookMainUI();
		ui.execute();
	}

}
