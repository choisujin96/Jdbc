package com.javaex.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex01.AuthorVO;
import com.javaex.ex02.BookAuthorVo;

public class BookDAO {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/web_db";
	private String id = "web";
	private String pw = "web";

	// 생성자

	public BookDAO() {

	}

	// 메소드gs

	// 메소드일반

	// DB연결 메소드 - 공통
	private void connect() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 자원 정리 메소드 -공통
	private void close() {
		// 5. 자원정리
		try {

			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 책등록
	public int bookInsert(String title, String pubs, String pubDate, int authorId) {

		int count = -1;

		// 0. import java.sql.*;
		// Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
		// 각각 갖고 있기 때문에 **필드로 빼줌. 나중엔 삭제할 예정임
		// 1. JDBC 드라이버 (Oracle) 로딩 //얘네는 ***메소드로 뺐음
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행

			// SQL문 준비
			String query = "";
			query += " insert into book ";
			query += " values (null, ?, ?, ?, ?) ";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title); // 메소드의 파라미터
			pstmt.setString(2, pubs);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, authorId);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return count;
	}// 등록

	// 책수정
	public int bookUpdate(int bookId, String title, String pubs, String pubDate, int authorId) {

		int count = -1;

		// 0. import java.sql.*;
		// 1. JDBC 드라이버 (mysql) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행

			// SQL문 준비
			String query = "";
			query += " update book ";
			query += " set  title = ? ";
			query += " 		,pubs = ? ";
			query += " 		,pub_date = ? ";
			query += " 		,author_id = ? ";
			query += " where book_id = ? ";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, authorId);
			pstmt.setInt(5, bookId);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		// 5. 자원정리
		this.close();

		return count;
	}// Update

	// 책삭
	public int bookDelete(int bookId) {

		int count = -1;

		// 0. import java.sql.*;
		// 1. JDBC 드라이버 (mysql) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행

			// SQL문 준비
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		// 자원정리
		this.close();

		return count;

	} // delete

	// 책리스트
	public List<BookVO> bookSelect() {

		// 리스트
		List<BookVO> bookList = new ArrayList<BookVO>();

		// 0. import java.sql.*;

		// 1. JDBC 드라이버 (MySQL) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select 	book_id, ";
			query += "          title, ";
			query += "          pubs, ";
			query += "          date_format(pub_date, '%Y-%m-%d') as 'pub_date', ";
			query += "          author_id ";
			query += " from book ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리 (java 리스트로 만든다)
			while (rs.next()) {

				int bookId = rs.getInt("book_id");
				String bookTitle = rs.getString("title");
				String bookPub = rs.getString("pubs");
				String bookPubDate = rs.getString("pub_date");
				int bookAuthorId = rs.getInt("author_id");

				// 데이터 객체로 만들기(묶기)
				BookVO bookVO = new BookVO(bookId, bookTitle, bookPub, bookPubDate, bookAuthorId);

				// 묶은 데이터를 리스트에 달기
				bookList.add(bookVO);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return bookList;

	}

	// 책리스트에서 데이터 한개 꺼내오기
	public BookVO bookSelectOne(int bookId) {

		// VO
		BookVO bookVO = null;

		// 0. import java.sql.*;

		// 1. JDBC 드라이버 (MySQL) 로딩
		// 2. Connection 얻어오기
		this.connect();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select book_id, ";
			query += "        title, ";
			query += "        pubs, ";
			query += "        date_format(pub_date, '%Y-%m-%d') as 'pub_date', ";
			query += "        author_id ";
			query += " from book ";
			query += " where book_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, bookId);

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리 (java 리스트로 만든다)
			rs.next();

			int id = rs.getInt("book_id");
			String Title = rs.getString("title");
			String Pub = rs.getString("pubs");
			String PubDate = rs.getString("pub_date");
			int baId = rs.getInt("author_id");

			bookVO = new BookVO(id, Title, Pub, PubDate, baId);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return bookVO;

	}

	
	//리스트 전체
	public List<BookAuthorVo> bookSelectList(){

	
		List<BookAuthorVo> baList = new ArrayList<BookAuthorVo>();
		
		// 0. import java.sql.*;
		
		// 1. JDBC 드라이버 (MySQL) 로딩
		// 2. Connection 얻어오기
		this.connect();	

		try {
			
			// 3. SQL문 준비 / 바인딩 / 실행
			
			// SQL문 준비
			String query = "";
			query += " select 	bo.book_id "; 
			query += "         ,bo.title ";
			query += "         ,bo.pubs ";
			query += "         ,bo.pub_date ";
			query += "         ,au.author_id ";
			query += "         ,au.author_name ";
			query += "         ,au.author_desc ";
			query += " from book bo, author au ";
			query += " where bo.author_id = au.author_id; ";
			System.out.println(query);
						
			
			// 바인딩 
			pstmt = conn.prepareStatement(query);
			
			
			
			//실행
			rs = pstmt.executeQuery();

		    // 4.결과처리 (java 리스트로 만든다)
			while(rs.next()) { //커서 만들기 커서가 내려가면 true, 내려갈 곳이 없으면 false라고 판단해서 끝냄
					
				//ResultSet의 데이터를 자바의 변수에 담는다.
				 //만든변수            //컬럼명
				
				int bookID= rs.getInt("book_id"); 
				String bookTitle = rs.getString("title");
				String bookPub = rs.getString("pubs");
				String bookPubdate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
			
				BookAuthorVo baVO = new BookAuthorVo(bookID, bookTitle, bookPub, bookPubdate, 
													 authorId, authorName, authorDesc);
	
				//VO를 리스트에 추가(add())한다
				baList.add(baVO);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		// 5. 자원정리
		this.close();
		
		return baList;
		
		
	}
	
	

}
