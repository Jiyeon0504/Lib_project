package kr.ac.kopo.book.service;

import java.util.List;

import kr.ac.kopo.book.dao.BookDAO;
import kr.ac.kopo.book.vo.BookVO;
import kr.ac.kopo.book.vo.rentBookVO;

public class BookService {

	private BookDAO bookDao;

	public BookService() {
		bookDao = new BookDAO();
	}

	public void insertBook(BookVO book) {

		bookDao.insertBook(book);
	}
	
	public void rentBook(rentBookVO book) {
		
		bookDao.rentBook(book);
		
	}
	
	
public void returnBook(int no) {
		
		bookDao.returnBook(no);
		
	}
	
	
	
	
	public List<rentBookVO> rentAll(){
		List<rentBookVO> rentList = bookDao.rentAllBook();
		return rentList;
	}
	

	public List<BookVO> selectAll(){
		List<BookVO> bookList = bookDao.selectAllBook();
		return bookList;
	}
	public BookVO selectByNo(int bookNo) {
		BookVO book = bookDao.selectBookByNo(bookNo);
		return book;
	}

	public BookVO selectByTitle(String bookTitle) {
		BookVO book = bookDao.selectBookByTitle(bookTitle);
		return book;
	}

	public BookVO selectByWriter(String writerm) {
		BookVO book = bookDao.selectBookByWriter(writerm);
		return book;
	}

	public BookVO selectByIsbn(String isbn) {
		BookVO book = bookDao.selectBookByisbn(isbn);
		return book;
	}


	public void deleteBook(String pass, int no) {
		bookDao.deleteBook(pass,no);
	}
	
}
