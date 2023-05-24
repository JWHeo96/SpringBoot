package com.ezen;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ezen.domain.Board;

public class JPAClient {

	public static void main(String[] args) {
		// EntityManager 생성
				EntityManagerFactory emf = 
						Persistence.createEntityManagerFactory("Chap04");
				
				EntityManager em = emf.createEntityManager();
				try {
					Board board = new Board();
					
					board.setSeq(1);
					board.setTitle("게시글 제목");
					board.setWriter("작성자");
					board.setContent("게시글 내용입니다...");
					board.setCreateDate(new Date());
					board.setCnt(0);
					
					em.persist(board);
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					emf.close();
					em.close();
				}
	}

}
