package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex01.AuthorVO;

public class BookSelectAll {

	public static void main(String[] args) {
		
		
	List<BookAuthorVo> baList = new ArrayList<BookAuthorVo>();
	
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			
		    // 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/web_db";
			conn = DriverManager.getConnection(url, "web", "web");  //연결하기
			

		    // 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
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
			
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			
			
			//실행
			rs= pstmt.executeQuery();
			
			
		    
		    // 4.결과처리
			//rs 표가 들어가 있다 (사용이 불편함) --> 리스트에 담는다.
			
			
			while(rs.next()) { //커서 만들기 커서가 내려가면 true, 내려갈 곳이 없으면 false라고 판단해서 끝냄
				
				//ResultSet의 데이터를 자바의 변수에 담는다.
				 //만든변수            //컬럼명
				
				int bookId = rs.getInt("book_id"); 
				String bookTitle = rs.getString("title");
				String bookPub = rs.getString("pubs");
				String bookPubdate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				
				/*                                                     //둘 다 가능인데 컬럼명작성하는 법을 더 많이 쓴다.
				int authorId = rs.getInt(1);
				String authorName = rs.getString(2);
				String authorDesc = rs.getString(3);
				*/
				
				
				
				//자바의 데이터를 VO로 묶는다
				BookAuthorVo baVO = new BookAuthorVo(bookId, bookTitle, bookPub, bookPubdate, 
													authorId, authorName, authorDesc);
				
				//VO를 리스트에 추가(add())한다
				baList.add(baVO);
			
				
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
	
		/*
		for(int i=0; i<aList.size(); i++) {
			System.out.println(aList.get(i).toString());
			
		}
	    
		System.out.println("------------------------------------------");
		
		System.out.println(aList.get(0).getAuthorName());
		*/
		
		
		System.out.println("--------------------------");
		for(int i=0; i<baList.size(); i++) {
			
			int bookId = baList.get(i).getBook_id();
			String bookTitle = baList.get(i).getTitle();
			String bookPub = baList.get(i).getPubs();
			String bookPubdate = baList.get(i).getPub_date();
			int authorId = baList.get(i).getAuthor_id();
			String authorName = baList.get(i).getAuthorName();
			String authorDesc = baList.get(i).getAuthorDesc();
			
			System.out.println(bookId + ". " + bookTitle + "/ " + bookPub + "/ " + bookPubdate + "/ "
								+ authorId + ". " + authorName + "(" + authorDesc + ")");
			
		}
		System.out.println("--------------------------");	
		
		
		
		
		
		
	}

}
