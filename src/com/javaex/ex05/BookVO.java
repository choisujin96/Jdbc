       package com.javaex.ex05;

public class BookVO {

	//필드
	private int bookId;
	private String bookTitle;
	private String bookPubs;
	private String bookPubDate;
	private int bookAuthorId;

	//생성자
	public BookVO() {
		
	}
	
	
	public BookVO(int bookId, String bookTitle, String bookPub, String bookPubDate, int bookAuthorId) {
		
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPubs = bookPub;
		this.bookPubDate = bookPubDate;
		this.bookAuthorId = bookAuthorId;
	}
	
	
	//메소드gs	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPub() {
		return bookPubs;
	}
	
	public void setBookPub(String bookPubs) {
		this.bookPubs = bookPubs;
	}
	
	public String getBookPubDate() {
		return bookPubDate;
	}
	
	public void setBookPubDate(String bookPubDate) {
		this.bookPubDate = bookPubDate;
	}
	
	public int getBookAuthorId() {
		return bookAuthorId;
	}
	
	public void setBookAuthorId(int bookAuthorId) {
		this.bookAuthorId = bookAuthorId;
	}
	
	//메소드 일
	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPubs=" + bookPubs + ", bookPubDate="
			  + bookPubDate + ", bookAuthorId=" + bookAuthorId + "]";
	}
	
	
	

}
