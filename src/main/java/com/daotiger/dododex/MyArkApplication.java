package com.daotiger.dododex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyArkApplication extends SpringBootServletInitializer {
	// public class MyArkApplication{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyArkApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MyArkApplication.class, args);
	}

}
