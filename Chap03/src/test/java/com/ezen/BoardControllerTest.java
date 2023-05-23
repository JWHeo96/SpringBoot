package com.ezen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.ezen.service.BoardService;

//@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)	// 웹서버를 사용하지 않는 테스트
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // 웹서버를 사용하는 테스트
public class BoardControllerTest {

	@Autowired
	private MockMvc mockMvc;
//	@Autowired
//	private TestRestTemplate restTemplate;
	
	@MockBean	// BoardServvice 객체 모형화 어노테이션
	private BoardService boardService;
	
	@Test
	@Disabled	// 테스트 제외 어노테이션
	public void testHello() throws Exception {
		mockMvc.perform(get("/hello").param("name","gildong"))
			.andExpect(status().isOk())	// 콘트롤러에서 200 응답을 기대
			.andExpect(content().string("Hello: gildong"))
			.andDo(print());
	}

	/*
	// 웹 서버를 사용한 테스트
	@Test
	@Disabled
	public void testHello2() throws Exception {
		String result = restTemplate.getForObject("/hello?name=Gildong",String.class);

		// result = 콘트롤러부터의 실제 결과
		assertEquals("Hello: Gildong", result); // 위의 URL 요청에 대한 예상결과 비교
	}
	
	
	// getBoard() 테스트
	@Test
	@Disabled
	public void testGetBoard() throws Exception {
		
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		
		assertEquals("게시글 제목", board.getTitle());
	}
	
	*/
	
	// 서비스 계층 테스트
	@Test
	public void testHelloService() throws Exception {
		when(boardService.hello("Gildong")).thenReturn("Hello: Gildong");
		
		mockMvc.perform(get("/hello").param("name", "Gildong"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello: Gildong"))
			.andDo(print());
	}
}
