package com.ezen.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.ezen.demo", "com.ezen.example"})
public class Chap01Application {

	public static void main(String[] args) {
		SpringApplication.run(Chap01Application.class, args);
	}

}
