package com.ariv.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringbootAwsElasticBeanstalkApplication {

	@GetMapping("/status")
	public String deploy() {
		return "Application deployed to AWS Beanstack";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsElasticBeanstalkApplication.class, args);
	}

}
