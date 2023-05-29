package com.ezen.persistence;

import org.springframework.data.repository.CrudRepository;
import com.ezen.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
