package kr.ac.kopo.book.ui;

import java.util.List;

import kr.ac.kopo.book.service.BookService;
import kr.ac.kopo.book.vo.BookVO;
import kr.ac.kopo.member.ui.FoundationUI;


public class searchAllUI extends FoundationUI {

	private BookService service;
	
	public searchAllUI() {
		service = new BookService();
	}
	
	@Override
	public void execute() throws Exception {
		List<BookVO> bookList  = service.selectAll();
		
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("NO\t도서명\t\t\t\t저자\t\t\t\t출판사\t\t\tISBN");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		if(bookList == null || bookList.size() ==0) {
			System.out.println("게시글이 존재하지 않습니다");
		}else {
			for(BookVO book : bookList) {
				System.out.println(book.getNo() + "  \t "
								+ book.getTitle()+"    \t\t"
								+ "\t"+book.getWriter()+"\t\t\t"
								+ "\t"+book.getPublisher()+"\t\t"
								+ "\t"+book.getISBN());
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		
		
	}

}
