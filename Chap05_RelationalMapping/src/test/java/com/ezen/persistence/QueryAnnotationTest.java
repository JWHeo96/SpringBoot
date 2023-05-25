package com.ezen.persistence;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ezen.domain.Board;

@SpringBootTest
public class QueryAnnotationTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	@Disabled
	public void testQueryAnnotation1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("제목 5");
		
		System.out.println(">>>> 조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	@Disabled
	public void testQueryAnnotation2() {
		List<Board> boardList = boardRepo.queryAnnotationTest2("제목 6");
		
		System.out.println(">>>> 조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	@Disabled
	public void testQueryAnnotation3() { 
		List<Object[]> result = boardRepo.queryAnnotationTest3("제목 7");
		
		System.out.println(">>>> 조회 결과");
		for(Object[] item : result) {
			System.out.println(Arrays.toString(item));
		}
	}
	
	@Test
	@Disabled
	public void testQueryAnnotation4() { 
		List<Object[]> result = boardRepo.queryAnnotationTest4("제목 8");
		
		System.out.println(">>>> 조회 결과");
		for(Object[] item : result) {
			System.out.println(Arrays.toString(item));
		}
	}
	
	@Test
	public void testQueryAnnotation5() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		List<Object[]> result = boardRepo.queryAnnotation5(paging);
		
		System.out.println(">>>> 조회 결과");
		for(Object[] item : result) {
			System.out.println(Arrays.toString(item));
		}
	}
}
