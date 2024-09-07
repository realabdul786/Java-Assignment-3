package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")  			// Enable @Entity annotation 
@EnableJpaRepositories(basePackages = "com.repository")
public class SpringbootJpaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaAssignmentApplication.class, args);
	}

}
