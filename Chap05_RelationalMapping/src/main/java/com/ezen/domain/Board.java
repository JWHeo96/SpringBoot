package com.ezen.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Getter
@Setter
@ToString(exclude="member")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity	// 엔티티 클래스(데이터베이스 관련 객체)로 지정
public class Board {
	
	@GeneratedValue
	@Id	// 기본키 지정
	private long seq;
	
	private String title;
	//private String writer;	// member 필드가 있으므로 필요 없음
	private String content;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createDate;
	private int cnt;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable = false)
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
