package com.springboot.demo.service;

import org.springframework.stereotype.Component;

//spring to manage this bean and create an instance of this
@Component
public class WelcomeService {
	public String revMessage() {
		
		return "Welcome Eray! ";
	}
}