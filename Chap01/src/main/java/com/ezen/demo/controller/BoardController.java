package com.ezen.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.domain.BoardVO;

// 화면을 리턴하는게 아니라 일반적인 데이터를 리턴한다
@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		
		return "Hello: " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		
		BoardVO board = new BoardVO();
		
		board.setSeq(1);
		board.setTitle("게시글 제목");
		board.setWriter("작성자");
		board.setContent("게시글 내용입니다...");
		board.setCreateDate(new Date());
		board.setCnt(0);
		
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList<>();
		
		for(int i=1; i<10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("게시글 제목" + i);
			board.setWriter("작성자");
			board.setContent(i + "번째 게시글 내용입니다...");
			board.setCreateDate(new Date());
			board.setCnt(0);
			
			boardList.add(board);
		}
		
		return boardList;
	}
}
