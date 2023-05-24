package com.ezen.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity	// 엔티티 클래스(데이터베이스 관련 객체)로 지정
@Table(name="Board")
/* 키값의 테이블 생성 전략
@TableGenerator(name="BOARD_SEQ_GENERATOR",
				table="ALL_SEQUENCES",
				pkColumnValue = "BOARD_SEQ",
				initialValue = 0,
				allocationSize = 1)
				*/
/* 키값의 시퀀스 생성 전략
@SequenceGenerator(name="BOARD_SEQ_GENERATOR",
					sequenceName="BOARD_SEQUENCE",
					initialValue = 1,
					allocationSize = 1)
					*/
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Board() {
		super();
	}
	
	//@GeneratedValue(//strategy = GenerationType.TABLE, // 키 자동생성 방법 : 테이블 방식 이용
					//strategy=GenerationType.SEQUENCE, // 키 자동생성 방법: 시퀀스 객체 이용
					//generator="BOARD_SEQ_GENERATOR"
	//				) 
	@GeneratedValue
	@Id	// 기본키 지정
	private int seq;
	
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private int cnt;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
	
   
}
