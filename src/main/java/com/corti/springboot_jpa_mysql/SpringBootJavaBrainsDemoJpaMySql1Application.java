package com.corti.springboot_jpa_mysql;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJavaBrainsDemoJpaMySql1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJavaBrainsDemoJpaMySql1Application.class, args);
	}

	@PostConstruct
	public void init(){
	  // Setting Spring Boot TimeZone
	  TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
