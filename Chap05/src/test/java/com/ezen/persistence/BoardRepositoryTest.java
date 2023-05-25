package com.ezen.persistence;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.domain.Board;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	// 데이터 Insert
	@Test
	@Disabled
	public void testInsertBoard() {
		Board board = new Board();
		
		board.setTitle("첫번째 게시글");
//		board.setWriter("작성자");
		board.setContent("게시글 내용입니다...");
		board.setCreateDate(new Date());
		board.setCnt(0);
		
		boardRepo.save(board);
	}
	
	// 조회 기능 테스트
	@Test
	@Disabled
	public void testGetBoard() {
		Board board = boardRepo.findById(2L).get();
		
		System.out.println(board.toString());
	}
	
	// 수정 기능 테스트
	@Test
	@Disabled
	public void testUpdateBoard() {
		Board board = boardRepo.findById(2L).get();
		
		board.setTitle("게시글 제목 수정");
		
		boardRepo.save(board);
	}
	
	// 삭제 기능 테스트
	@Test
	public void testDeleteBoard() {
		
		boardRepo.deleteById(2L);
	}
}






