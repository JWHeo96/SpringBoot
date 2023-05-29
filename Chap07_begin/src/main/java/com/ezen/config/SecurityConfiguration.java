package com.ezen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	/*
	 * security - 사용자 인증 정보를 가지고 있는 객체
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/").permitAll();
		// authenticated() - id, pwd를 통해 인증된 회원만 접근 가능한 URL 지정
		security.authorizeRequests().antMatchers("/member/**").authenticated();
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		security.csrf().disable();	// Cross Site Request Forgery disable
		// formLogin() - 사용자가 지정한 로그인 화면 사용
		// loginPage() - 지정한 URL을 요청하면 로그인 화면을 표시
		security.formLogin().loginPage("/login");		
		
		return security.build(); // 위에서 설정한 권한정보를 스프링 Security에 적용
	}
}
