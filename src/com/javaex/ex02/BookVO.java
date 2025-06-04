package com.javaex.ex02;

public class BookVO {
	
	
	//필드
	private int book_id;
	private String title;
	private String pubs;
	private String pub_date;
	private int author_id;
	
	//생성자
	public BookVO() {
	
	}

	public BookVO(int book_id, String title, String pubs, String pub_date, int author_id) {

		this.book_id = book_id;
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.author_id = author_id;
	}

	
	//메소드gs
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPub_date() {
		return pub_date;
	}

	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	

	
	
    //메소드
	@Override
	public String toString() {
		return "BookVO [book_id=" + book_id + ", title=" + title + ""
								  + ", pubs=" + pubs + ", pub_date=" + pub_date
								  + ", author_id=" + author_id + "]";
	}	
}
