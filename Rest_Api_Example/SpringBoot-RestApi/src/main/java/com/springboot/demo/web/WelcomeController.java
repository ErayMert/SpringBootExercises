package com.springboot.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.service.WelcomeService;


@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService service;
	
	public WelcomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return service.revMessage();
	}

}


