package com.ezen.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ezen.domain.Board;
import com.ezen.domain.QBoard;
import com.querydsl.core.BooleanBuilder;

@SpringBootTest
public class DynamicQueryTest {

	@Autowired
	private DynamicBoardRepository boardRepo;
	
	@Test
	public void testDynamicQuery() {
		String searchCondition = "WRITER";
		String searchKeyword = "작성자";
		
		/* 동적인 조건 생성 */
		// BooleanBuilder - 쿼리문의 WHERE절 이하의 조건을 생성해 주는 객체
		// (1) BooleanBuilder 생성
		BooleanBuilder builder = new BooleanBuilder();
		
		// (1-1) Q클래스 생성
		QBoard qboard = QBoard.board;
		
		// (2) searchCondition의 내용에 따라 동적인 쿼리 생성
		if (searchCondition.equals("TITLE")) {
			
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
			
		} else if (searchCondition.equals("CONTENT")) {
		
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
			
		} else if(searchCondition.equals("WRITER")) {
			
			//builder.and(qboard.writer.eq(searchKeyword));
			
		}
		
		Pageable paging = PageRequest.of(0,  5);
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println(">>>>> 검색 결과");
		for (Board board : boardList.getContent()) {
			System.out.println(board);
		}
	}
}









