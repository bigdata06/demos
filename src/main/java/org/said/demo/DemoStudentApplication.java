package org.said.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStudentApplication.class, args);
	}
}
