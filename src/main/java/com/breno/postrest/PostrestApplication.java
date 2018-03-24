package com.breno.postrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostrestApplication.class, args);
		System.out.println("API in Operation!");
	}
}
