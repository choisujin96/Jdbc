package com.javaex.ex02;

public class BookAuthorVo {
	
	//필드
	private int book_id;
	private String title;
	private String pubs;
	private String pub_date;
	
	private int authorId;
	private String authorName;
	private String authorDesc;
	
	
	//생성자
	public BookAuthorVo() {
		super();
	}
	
	
	public BookAuthorVo(int book_id, String title, String pubs, String pub_date, 
						int author_id, String authorName, String authorDesc) {
	
		this.book_id = book_id;
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.authorId = author_id;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
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
		return authorId;
	}


	public void setAuthor_id(int author_id) {
		this.authorId = author_id;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getAuthorDesc() {
		return authorDesc;
	}


	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}


	
	
	//메소드
	
	@Override
	public String toString() {
		return "BookAuthorVo [book_id=" + book_id + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pub_date
				+ ", authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}


	
	

}
