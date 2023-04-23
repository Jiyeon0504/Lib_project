package kr.ac.kopo.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.book.vo.BookVO;
import kr.ac.kopo.book.vo.rentBookVO;
import kr.ac.kopo.util.ConnectionFactory;

public class BookDAO {

	private List<BookVO> bookList;

	public BookDAO() {

	}
	
public void returnBook(int no) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete RENTAL_LIST_T ");
		sql.append("WHERE book_NO = ?");
//		book.setBookName(selectBookByNo(book.getBookNo()).getTitle());

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, no);
	        int count = pstmt.executeUpdate();
	        
			if (count > 0) {
				
				System.out.println("반납 완료되었습니다");
			}else { 
				System.out.println("잘못입력하셨습니다");
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} 
	
	public void rentBook(rentBookVO book) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO RENTAL_LIST_T (");
		sql.append("       RENTAL_NO, ");
		sql.append("       USER_ID, ");
		sql.append("       BOOK_NAME, ");
		sql.append("       BOOK_NO ");
		sql.append(") VALUES ( ");
		sql.append("       SEQ_LENTAL_TABLE_NO.NEXTVAL, ?, ?, ?)");
		book.setBookName(selectBookByNo(book.getBookNo()).getTitle());

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setString(1, book.getUserID());
			pstmt.setString(2, book.getBookName());
			pstmt.setInt(3, book.getBookNo());
		
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	public void insertBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into book_table(no, title, writer, publisher, ISBN)");
		sql.append(" values(seq_book_table_no.NEXTVAL, ?, ?, ?, ?) ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setString(4, book.getISBN());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void deleteBook(String pass, int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT pass FROM mng_table WHERE pass = ?");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) 
			{

			pstmt.setString(1, pass);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String Pass = rs.getString("pass");
				
//				int resultNo = rs.getInt("no");

//				if (resultNo == no) {

				sql = new StringBuilder();
				sql.append("DELETE FROM book_table WHERE no = ?");

				try (PreparedStatement pstmt2 = conn.prepareStatement(sql.toString())) {
					pstmt2.setInt(1, no);
					int count = pstmt2.executeUpdate();
					if (count > 0) {
						System.out.println("삭제 완료");

					}else {
						System.out.println("해당도서는 없는도서입니다");
					}
//					}
				}
			} else {
				System.out.println("비밀번호가 올바르지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<rentBookVO> rentAllBook() {
		List<rentBookVO> rentList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select book_name, book_no, rental__date, return_date ");
		sql.append("  from rental_list_t ");
		sql.append(" order by rental_no");
		
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) 
		{
			ResultSet rs = pstmt.executeQuery(); // resultset 리턴이 필요함
			while (rs.next()) {
				String name = rs.getString("book_name");
				int no = rs.getInt("book_no");
				Date rlDate = rs.getDate("rental__date");
				Date rnDate = rs.getDate("return_date");

				rentBookVO book2 = new rentBookVO();
				book2.setBookName(name);
				book2.setBookNo(no);
				book2.setRtDate(rnDate);
				book2.setRnDate(rnDate);

//					System.out.println(board);
				rentList.add(book2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentList;

	}
	
	public List<BookVO> selectAllBook() {
		List<BookVO> bookList = new ArrayList<>();
	
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, isbn ");
		sql.append("  FROM book_table ");
		sql.append(" order by no");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) 
		{
			ResultSet rs = pstmt.executeQuery(); // resultset 리턴이 필요함
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String ISBN = rs.getString("ISBN");
			
				BookVO book = new BookVO();
				rentBookVO rent = new rentBookVO();
				book.setNo(no);
				book.setTitle(title);
				book.setWriter(writer);
				book.setPublisher(publisher);
				book.setISBN(ISBN);
				

//					System.out.println(board);
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;

	}

	public BookVO selectBookByisbn(String bookisbn) {
		BookVO book = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, ISBN ");
		sql.append("  from book_table ");
		sql.append("  WHERE ISBN = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, bookisbn);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("ISBN");
				System.out.println();
				book = new BookVO(no, title, writer, publisher, isbn);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return book;
	}

	public BookVO selectBookByNo(int bookno) {
		BookVO book = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, ISBN ");
		sql.append("  from book_table ");
		sql.append("  WHERE no = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setInt(1, bookno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("ISBN");
				System.out.println();
				book = new BookVO(no, title, writer, publisher, isbn);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return book;
	}
	
	
	public BookVO selectBookByTitle(String titlem) {

		BookVO book = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, ISBN ");
		sql.append("  from book_table ");
		sql.append("  WHERE instr(upper(title), ?)> 0");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, titlem.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("ISBN");
				System.out.println();
				book = new BookVO(no, title, writer, publisher, isbn);
//				System.out.println(book);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return book;

	}

	public BookVO selectBookByWriter(String writerm) {

		BookVO book = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, ISBN ");
		sql.append("  from book_table ");
		sql.append("  where instr(upper(writer),?) > 0 ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, writerm.toUpperCase());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String isbn = rs.getString("ISBN");
//				System.out.println(book);
				book = new BookVO(no, title, writer, publisher, isbn);
//				System.out.println(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return book;
	}

	
	
	
	
	
	

}















































