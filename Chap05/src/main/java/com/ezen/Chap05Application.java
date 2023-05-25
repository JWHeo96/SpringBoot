package com.ezen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chap05Application {

	public static void main(String[] args) {
		//SpringApplication.run(Chap05Application.class, args);
		
		SpringApplication application 
			= new SpringApplication(Chap05Application.class);
		
		// Java application으로 실행
		application.setWebApplicationType(WebApplicationType.NONE);
		
		application.run(args);
	}

}
