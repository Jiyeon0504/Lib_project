package kr.ac.kopo.book.ui;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.book.vo.BookVO;
import kr.ac.kopo.member.ui.FoundationUI;


public class TitleSearchUI extends FoundationUI {

	private BookService service;
	
	public TitleSearchUI() {
		service = new BookService();
	}
	
	
	@Override
	public void execute() throws Exception {
		
		String title = scanStr("조회할 도서명을 입력하세요:");
		
		BookVO book = service.selectByTitle(title);
		System.out.println("---------------------------------------------------------------------------------------------------------------");
//		System.out.println(book);
		
		if(book == null) {
//			System.out.println(book);
			System.out.println("해당["+title+"]제목의 도서는 존재하지 않습니다");
		}else {
			System.out.println("NO\t도서명\t\t\t\t저자\t\t\t출판사\t\t\tISBN");
			System.out.println(book.getNo() + "  \t "
								+book.getTitle()+"    \t\t"
						+ "\t"+book.getWriter()+"\t\t"
						+ "\t"+book.getPublisher()+"\t\t"
						+ "\t"+book.getISBN());
		
			
		
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		
	}


	
}
