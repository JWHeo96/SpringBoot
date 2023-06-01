package com.ezen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ezen.domain.Member;
import com.ezen.domain.Role;
import com.ezen.persistence.MemberRepository;

@SpringBootTest
public class PasswordEncoderTest {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member2 = new Member();
		member2.setId("manager2");
		member2.setName("매니저2");
		member2.setPassword(encoder.encode("1234"));
		member2.setRole(Role.ROLE_MANAGER);
		member2.setEnabled("true");
		memberRepo.save(member2);
	}
}
