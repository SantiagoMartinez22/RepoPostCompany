package com.workshop.postal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.workshop.postal.models")
public class PostalCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostalCompanyApplication.class, args);
	}

}
