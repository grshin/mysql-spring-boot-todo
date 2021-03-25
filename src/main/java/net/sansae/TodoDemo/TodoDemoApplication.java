package net.sansae.TodoDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TodoDemoApplication extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(TodoDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoDemoApplication.class, args);
	}
}
