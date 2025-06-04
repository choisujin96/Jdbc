package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSelect {

	public static void main(String[] args) {

		List<BookVO> bList = new ArrayList<BookVO>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			

		    // 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/web_db";
			conn = DriverManager.getConnection(url, "web", "web"); 

		    // 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select	book_id ";
			query += " 			,title ";
			query += " 			,pubs ";
			query += " 			,pub_date ";
			query += " 			,author_id ";
			query += " from book ";
			System.out.println(query);
			
		    
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			//실행
			rs = pstmt.executeQuery();
			
			
		    // 4.결과처리
			while(rs.next()) {
				
			int bookId = rs.getInt("book_id"); 
			String bookTitle = rs.getString("title");
			String bookPub = rs.getString("pubs");
			String bookPubdate = rs.getString("pub_date");
			int bookAuthorId = rs.getInt("author_id");
				
			
			BookVO bkVO = new BookVO(bookId, bookTitle, bookPub, bookPubdate, bookAuthorId);
			
			bList.add(bkVO);
			
				
			}
			

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
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


		System.out.println("--------------------------------");
		for(int i=0; i<bList.size(); i++) {
			int bookId = bList.get(i).getBook_id();
			String bookTitle = bList.get(i).getTitle();
			String bookPub = bList.get(i).getPubs();
			String bookPubdate = bList.get(i).getPub_date();
			int bookAuthorId = bList.get(i).getAuthor_id();
			
			System.out.println(bookId + ". " + bookTitle + "/ " + bookPub + "/ " + bookPubdate + "/ " + bookAuthorId);
		}
		System.out.println("--------------------------------");
		
		
		
	}//main

}
