package com.ezen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ezen.domain.Board;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// EntityManager 생성
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("Chap04");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		/*
		// 게시글 삽입
		try {
			tx.begin();
			Board board = new Board();
			
			board.setTitle("게시글 제목");
			board.setWriter("작성자");
			board.setContent("게시글 내용입니다...");
			board.setCreateDate(new Date());
			board.setCnt(0);
			
			em.merge(board);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
			em.close();
		}
		*/
		/*
		// 게시글 조회
		try {
			Board board = em.find(Board.class, 1);
			System.out.println("===> " +  board);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
			em.close();
		}
		*/

		/*
		// 게시글 수정
		try {
			tx.begin();
			
			Board board = em.find(Board.class, 1);
			
			board.setContent("게시글 내용을 수정합니다.");
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
			em.close();
		}
		*/
		
		/*
		// 글 목록 조회
		try {
			String jpql = "SELECT b FROM Board b ORDER BY b.seq DESC";
			
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for(Board board : boardList) {
				System.out.println(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
			em.close();
		}
		*/
		
		// 게시글 삭제
		try {
			tx.begin();
			Board board = em.find(Board.class, 1);
			
			board.setSeq(1);
			
			em.remove(board);
			
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			
			tx.rollback();
		} finally {
			emf.close();
			em.close();
		}
    }
}
