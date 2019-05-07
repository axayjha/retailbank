package com.design.interestcalc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@EntityScan("com.design")
@ComponentScan("com.design") // I added this here
@EnableJpaRepositories(basePackages = "com.design") // I added this here
public class InterestCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterestCalcApplication.class, args);
	}

}
