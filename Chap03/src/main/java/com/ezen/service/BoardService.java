package com.ezen.service;

import java.util.List;

import com.ezen.BoardVO;

public interface BoardService {
	String hello(String name);
	BoardVO getBoard();
	List<BoardVO> getBoardList();
}
