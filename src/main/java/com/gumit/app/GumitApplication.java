package com.gumit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GumitApplication {

	public static void main(String[] args) {
		SpringApplication.run(GumitApplication.class, args);
	}

}
