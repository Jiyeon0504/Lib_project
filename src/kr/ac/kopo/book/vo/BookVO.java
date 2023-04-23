package kr.ac.kopo.book.vo;

import java.util.Date;

public class BookVO {

	private int no;
	private String title;
	private String writer;
	private String publisher;
	private String isbn;
	private Date rndate;
	
	
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getISBN() {
		return isbn;
	}
	public void setISBN(String iSBN) {
		isbn = iSBN;
	}
	public BookVO(int no, String title, String writer, String publisher, String iSBN) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		isbn = iSBN;
	}
	@Override
	public String toString() {
		return "BookVO [ no" + no +  "title=" + title + ", writer=" + writer + ", publisher=" + publisher + ", ISBN="
				+ isbn + "getTitle()=" + getTitle() + ", getWriter()=" + getWriter()
				+ ", getPublisher()=" + getPublisher() + ", getISBN()=" + getISBN() + super.toString() + "]";
	}
	public Date getRndate() {
		return rndate;
	}
	public void setRndate(Date rndate) {
		this.rndate = rndate;
	}
	
	

}
