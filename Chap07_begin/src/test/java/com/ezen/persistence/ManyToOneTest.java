package com.ezen.persistence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.domain.Board;
import com.ezen.domain.Member;
import com.ezen.persistence.BoardRepository;
import com.ezen.persistence.MemberRepository;



@SpringBootTest
public class ManyToOneTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	@Disabled
	public void testManyToOneInsert() {
		Member member1 = Member.builder()
				.id("member1")
				.password("1111")
				.name("홍길동")
				.role("User")
				.build();
		
		memberRepo.save(member1);
		
		Member member2 = Member.builder()
				.id("member2")
				.password("2222")
				.name("이순신")
				.role("Admin")
				.build();
		
		memberRepo.save(member2);
		
		// 게시글 데이터 저장
		for(int i=1; i<=3; i++) {
			Board board = Board.builder()
					.writer("홍길동")
					.title("홍길동이 작성한 게시글" + i)
					.content("홍길동 게시글 내용" + i)
					.createDate(new Date())
					.cnt(0L)
					.build();
			
			boardRepo.save(board);
		}
		
		for(int i=1; i<=3; i++) {
			Board board = Board.builder()
					.writer("이순신")
					.title("이순신이 작성한 게시글" + i)
					.content("이순신 게시글 내용" + i)
					.createDate(new Date())
					.cnt(0L)
					.build();
			
			boardRepo.save(board);
		}
	}
	
	// 조회 테스트(다대일 단방향 테스트)
	@Test
	@Disabled
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(7L).get();
		
		System.out.println(">>> 게시글 정보");
		System.out.println(board);
		
	}
	
}











