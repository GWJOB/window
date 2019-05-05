package com.qianxue.window;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qianxue.window.dao")
public class WindowApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindowApplication.class, args);
	}

}
