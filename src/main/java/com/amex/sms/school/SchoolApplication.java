package com.amex.sms.school;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SchoolApplication {


	@Autowired
	Environment environment;


	static Logger logger= LoggerFactory.getLogger(SchoolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);

	}

	@PostConstruct
	public void init(){
		logger.info("Our School name is {0}:"+environment.getProperty("school-name"));
	}


}
