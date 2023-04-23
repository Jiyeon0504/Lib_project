package kr.ac.kopo.book.ui;

import java.util.Scanner;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.book.service.bookServiceFactory;
import kr.ac.kopo.book.vo.BookVO;
import kr.ac.kopo.member.ui.FoundationUI;

public class insertBookUI extends FoundationUI {

	
private BookService bookService;

	
	public insertBookUI() {
		
		bookService = bookServiceFactory.getInstance();
	}
	
	
	@Override
	public void execute() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("도서명: "); 
		String title = sc.nextLine(); 
		

		System.out.println("저자명: ");
		String writer = sc.nextLine();

		System.out.println("출판사: ");
		String publisher = sc.nextLine();


		System.out.println("ISBN: ");
		String isbn = sc.nextLine();
		
				
		BookVO book = new BookVO();
		
		book.setTitle(title);
		book.setWriter(writer);
		book.setPublisher(publisher);
		book.setISBN(isbn);
		
		bookService.insertBook(book);
		System.out.println("도서가 등록되었습니다");
		
		bookManageUI ui = new bookManageUI();
		ui.execute();

	}

}
