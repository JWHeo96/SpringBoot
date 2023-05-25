package com.ezen.persistence;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ezen.domain.Board;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepo;
	
	//@BeforeEach	// 각 테스트 케이스 실행 전에 반드시 수행
	public void dataPrepare() {
		for (int i=1; i<=200; i++) {
			Board board = new Board();
			
			board.setTitle("게시글 제목 " + i);
//			board.setWriter("작성자");
			board.setContent("게시글 내용입니다..." + i);
			board.setCreateDate(new Date());
			board.setCnt(0);
			
			boardRepo.save(board);
		}
	}
	
	@Test
	@Disabled
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("게시글 제목 1");
		
		System.out.println(">>>> 조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	@Disabled
	public void testByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("게시글 내용입니다...1");
		
		System.out.println(">>>> 조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	@Disabled
	public void testByTitleContainingOrContentContaining() {
		List<Board> boardList = 
				boardRepo.findByTitleContainingOrContentContaining("13", "15");
						
		System.out.println(">>>> 조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	/* 페이징 처리 메소드 테스트
	@Test
	public void testByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5);
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		List<Board> boardList = 
				boardRepo.findByTitleContaining("제목 3", paging);
		System.out.println(">>>> 조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	*/
	
	// 페이징 정보 포함
	@Test
	@Disabled
	public void testByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		Page<Board> pageInfo = 
				boardRepo.findByTitleContaining("제목 3", paging);
		
		System.out.println("Page당 항목 수: " + pageInfo.getSize());
		System.out.println("전체 Page 수: " + pageInfo.getTotalPages());
		System.out.println("조회된 전체 항목 수: " + pageInfo.getTotalElements());
		System.out.println("다음 페이지 여부: " + pageInfo.hasNext());
		System.out.println("이전 페이지 여부: " + pageInfo.hasPrevious());
		
		List<Board> boardList = pageInfo.getContent();
		
		System.out.println(">>>> 조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
}
