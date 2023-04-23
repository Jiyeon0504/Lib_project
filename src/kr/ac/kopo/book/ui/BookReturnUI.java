package kr.ac.kopo.book.ui;

import java.util.Scanner;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.book.service.bookServiceFactory;
import kr.ac.kopo.book.vo.rentBookVO;
import kr.ac.kopo.member.ui.FoundationUI;

public class BookReturnUI extends FoundationUI {

	private BookService bookService;
	
	public BookReturnUI() {
		
		bookService = bookServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("책번호를 입력하세요: "); 
		int no = sc.nextInt(); 
//		
//		rentBookVO book = new rentBookVO();
//		
//		no = book.getBookNo();
//		
//		
		bookService.returnBook(no);
		
//		
//		rentBookVO book = new rentBookVO();
//		System.out.println(book.getBookName());
		BookMainUI ui = new BookMainUI();
		ui.execute();
	}

}
