package com.javaex.ex03;

import java.util.List;

public class AuthorApp {

	//메인프로그램
	public static void main(String[] args) {
			
		AuthorDAO authorDao = new AuthorDAO(); 
		
		/*
		//삭제
		int count = authorDao.authorDelete(14);
		if(count>0) {
			System.out.println("삭제되었습니다.");
		}else if(count<0) {
			System.out.println("알 수 없는 오류발생");
		}else {
			System.out.println("삭제되지 않았습니다.");
		}
		
		
		
		authorDao.authorDelete(8);
		authorDao.authorDelete(9);
		*/
		
		/*
		int count = authorDao.authorInsert("침착맨", "웹툰작가");
		if(count>0) {
			System.out.println("등록되었습니다.");
		}else if(count<0) {
			System.out.println("알 수 없는 오류발생");
		}else {
			System.out.println("등록되지 않았습니다.");
		}
		*/
		
		//authorDao.authorUpdate(2, "한강", "노벨상수상");
		
		
		List<AuthorVO> authorList = authorDao.authorList();
		
		
		//사용자용 출력화면
		for(int i=0; i<authorList.size(); i++) {
			AuthorVO authorVO = authorList.get(i);
			System.out.println(authorVO.getAuthorId() + ". " + authorVO.getAuthorName() 
								+ "(" + authorVO.getAuthorDesc()+ ")");
		}
	  //size 는 1부터니까 <= 에서 = 는 뺀다.
	
		
		//List<AuthorVO> authorList = authorDao.authorSelect
				
		
		
		
		
	}

}
