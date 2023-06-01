package com.ezen.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ezen.domain.Member;

/*
 * JPA에서 조회한 Member 정보를 스프링 시큐리티에서
 * 사용할 UserDetails로 변환하는 클래스
 */
public class SecurityUser extends User {
	
	
	public SecurityUser(Member member) {
		// 조상의 생성자를 호출하여 스프링 시큐리티에 
		// id, password, enabled 값 전달 : {noop} - 암호화 하지 않음.
//		super(member.getId(), "{noop}" + member.getPassword(),
//				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		super(member.getId(), member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));

	}

}
