package com.ezen.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ezen.domain.Member;
import com.ezen.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		// (1) MemberRepository에서 회원정보 조회
		Optional<Member> result = memberRepo.findById(username);
		if (!result.isPresent()) {
			throw new UsernameNotFoundException(username + ": 사용자가 존재하지 않습니다.");
		} else {
			Member member = result.get();
			
			// (2) UserDetails 타입의 객체로 리턴
			return new SecurityUser(member);
		}
	}
}
