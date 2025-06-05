package com.javaex.ex05;

public class BookApp {

	public static void main(String[] args) {
		
		BookDAO bookDAO = new BookDAO();
		
		//책등록
		bookDAO = bookInsert("태도에 관하여", "토스트", "2024.09.24",);
		
		//책수정
		bookDAO.bookUpdate();
		
		//책삭제
		bookDAO.bookDelete();
		
		//책리스트
		bookDAO.bookSelect();
		
		bookDAO.bookSelectOne();
		

	}

}
