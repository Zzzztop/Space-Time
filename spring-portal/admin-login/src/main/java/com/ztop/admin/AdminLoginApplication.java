package com.ztop.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.ztop.admin.mapper")
public class AdminLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminLoginApplication.class, args);
	}

}
