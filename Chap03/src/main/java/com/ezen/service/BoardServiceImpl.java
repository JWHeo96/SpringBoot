package com.ezen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ezen.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Hello: " + name;
	}

	@Override
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

	@Override
	public List<BoardVO> getBoardList() {
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
