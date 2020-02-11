package com.situ.btoa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;


@MapperScan(basePackages="com.situ.btoa",annotationClass=Repository.class)
@SpringBootApplication
public class BtoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtoaApplication.class, args);
	}

}
