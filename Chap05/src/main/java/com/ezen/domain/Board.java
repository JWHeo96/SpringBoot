package com.ezen.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Getter
@Setter
@ToString
@Entity   // 엔티티 클래스(데이터베이스 관련 객체)로 지정
public class Board {

	public Board() {
		super();
	}

	@GeneratedValue
	@Id   // 기본키 지정
	private long seq;
	
	private String title;
	private String writer;	
	private String content;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createDate;
	private int cnt;
	
}





