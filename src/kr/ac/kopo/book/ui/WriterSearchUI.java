package kr.ac.kopo.book.ui;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.book.vo.BookVO;
import kr.ac.kopo.member.ui.FoundationUI;

public class WriterSearchUI extends FoundationUI {

	private BookService service;
	
	public WriterSearchUI() {
		service = new BookService();
	}
	
	
	
	@Override
	public void execute() throws Exception {
	String writer = scanStr("조회할 저자명을 입력하세요:");
		
		BookVO book = service.selectByWriter(writer);
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		if(book == null) {
			System.out.println("해당 저자["+writer+"]의 도서는 존재하지 않습니다");
		}else {
			System.out.println("NO\t도서명\t\t\t\t저자\t\t\t출판사\t\t\tISBN");
			System.out.println(book.getNo() + "  \t "
					+ book.getTitle()+"    \t\t"
					+ "\t"+book.getWriter()+"\t\t"
					+ "\t"+book.getPublisher()+"\t\t"
					+ "\t"+book.getISBN());
		
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}

}
