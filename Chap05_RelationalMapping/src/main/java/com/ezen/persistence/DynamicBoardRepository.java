package com.ezen.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.ezen.domain.Board;

public interface DynamicBoardRepository extends JpaRepository<Board, Long>, 
		QuerydslPredicateExecutor<Board> {

}
