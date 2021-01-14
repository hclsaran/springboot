package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootSwaggerApplication {
//comment
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}

}
