package com.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.domain.BoardVO;
import com.ezen.service.BoardService;

// 화면을 리턴하는게 아니라 일반적인 데이터를 리턴한다
@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		
		return boardService.hello(name);
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		
		return boardService.getBoard();
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){
		
		
		return boardService.getBoardList();
	}
}
