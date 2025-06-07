package com.javaex.ex05;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		BookDAO bookDAO = new BookDAO();
		
		
		
		//책등록
		//int c01 = bookDAO.bookInsert("태도에 관하여", "토스트", "2024.09.24", 1);
		//int c02 = bookDAO.bookInsert("이처럼 사소한 것", "다신책방", "2021.03.09", 3);
		//int c03 = bookDAO.bookInsert("인어공주", "디즈니", "1996.04.05", 4);
		
		
		
		//책수정
		//int c02 = bookDAO.bookUpdate(2, "피노키오","나무나무","2015/06/26",3);
		//책삭제
		//int c03 = bookDAO.bookDelete(3);
		
		//책리스트
		//List<BookVO> bookList = bookDAO.bookSelect();
	    //System.out.print(bookList);
		
		
		//bookSelectOne();
	    BookVO bookVO = bookDAO.bookSelectOne(4);
	    System.out.println(bookVO);
	    
	    
	    
	    

	}

}
