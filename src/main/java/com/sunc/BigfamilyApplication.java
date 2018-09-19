package com.sunc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sunc.mapper")
public class BigfamilyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigfamilyApplication.class, args);
	}
}
