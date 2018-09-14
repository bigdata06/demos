package org.said.demo.controllers;

import org.said.modelStuff.DummyUser;
import org.said.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BigdataArchitect on 2018-01-24.
 */
@ComponentScan({"org.said.services"})
@RestController
public class DemoController {

    @Autowired
    public UserService userService;



    @RequestMapping("/demo")
	//@ResponseBody
	String body(){

		return "hello at : "+userService.getUserServiceName() +"id number # "+userService.getRandomNumber();
	}

	@RequestMapping(value = "/user", method= RequestMethod.POST, produces = "Application/json")
	//@PostMapping
	//@ResponseBody
	public ResponseEntity<DummyUser> getHelloMessage(@RequestBody DummyUser user){

		return new ResponseEntity<DummyUser>(user, HttpStatus.CREATED);
	}
}
