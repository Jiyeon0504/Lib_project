package kr.ac.kopo.book.ui;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.book.service.bookServiceFactory;
import kr.ac.kopo.member.ui.FoundationUI;


public class deleteBookUI extends FoundationUI {

	private BookService bookService;


	public deleteBookUI() {

		bookService = bookServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {
	
		
		String pass = scanStr("확인을 위해 비밀번호를 입력해주세요: ");
		
		System.out.print("책 번호를 입력하세요: ");
        int no = scanInt("");
 
        bookService.deleteBook(pass, no);
          	
        

	}
}































