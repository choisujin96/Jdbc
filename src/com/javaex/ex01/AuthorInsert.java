package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {
		// 작가 데이터 저장

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;   // select문에서만 사용

		try {
			// 1. JDBC 드라이버 (mysql) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

					
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/web_db";
			conn = DriverManager.getConnection(url, "web", "web");  //워크벤치의 아이디 패스워드


			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " insert into author ";                //반드시 워크벤치에서 성공한 쿼리문만 가져오기. 여기서 직접짜기 금지
			query += " values(null, ?, ?) ";     //  워크벤치에서 작성했던 ; 이거는 가져오지 말기, 앞뒤로 빈공간 만들기(안그럼 따닥따닥 붙어있기 때문에)
			System.out.println(query);
			
		
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "신재평");   // 물음표 첫번째에 신재평
			pstmt.setString(2, "페퍼톤스");   // 물음표 두번째에 페퍼톤스
			
			
			
			//실행
			int count = pstmt.executeUpdate();
			
			
			// 4.결과처리
			System.out.println(count + "건이 등록되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				
				if (rs != null) {
					rs.close();          // select문에서만 사용
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

	}

}
