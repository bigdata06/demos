package org.said.demo;

import org.said.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(scanBasePackages = {"org.said.services"})
public class DemoApplication {

	@Autowired
	private UserService userService;

	@RequestMapping("/demo")
	@ResponseBody
	String body(){

		return "hello at : "+userService.getUserServiceName() +"id number # "+userService.getRandomNumber();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
