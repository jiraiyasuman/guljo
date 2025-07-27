package com.guljo.guljo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.guljo.guljo.repository")
@EntityScan(basePackages = "com.guljo.guljo.entity")
@ComponentScan(basePackages = "com.guljo.guljo") // this may already exist

public class GuljoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuljoApplication.class, args);
	}

}
