package kr.ac.kopo.book.vo;

import java.sql.Date;

public class rentBookVO {

	private int rentalNo;
	private String userID;
	private String bookName;
	private int bookNo;
	private Date rtDate;
	private Date rnDate;
	
	
	public rentBookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(int rentalNo) {
		this.rentalNo = rentalNo;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public Date getRtDate() {
		return rtDate;
	}
	public void setRtDate(Date rtDate) {
		this.rtDate = rtDate;
	}
	public Date getRnDate() {
		return rnDate;
	}
	public void setRnDate(Date rnDate) {
		this.rnDate = rnDate;
	}
	public rentBookVO(int rentalNo, String userID, String bookName, int bookNo, Date rtDate, Date rnDate) {
		super();
		this.rentalNo = rentalNo;
		this.userID = userID;
		this.bookName = bookName;
		this.bookNo = bookNo;
		this.rtDate = rtDate;
		this.rnDate = rnDate;
	}
	@Override
	public String toString() {
		return "rentBookVO [rentalNo=" + rentalNo + ", userID=" + userID + ", bookName=" + bookName + ", bookNo="
				+ bookNo + ", rtDate=" + rtDate + ", rnDate=" + rnDate + ", getRentalNo()=" + getRentalNo()
				+ ", getUserID()=" + getUserID() + ", getBookName()=" + getBookName() + ", getBookNo()=" + getBookNo()
				+ ", getRtDate()=" + getRtDate() + ", getRnDate()=" + getRnDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void setRentalDate(String rentalDate) {
		// TODO Auto-generated method stub
		
	}
	public void setReturnDate(String returnDate) {
		// TODO Auto-generated method stub
		
	}
	
	
}
