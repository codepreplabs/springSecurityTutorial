package com.codeprep.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping(value="/")
	public String welcomeMessage() {
		return "<h1> Welcome </h1>";
	}
	
	@GetMapping(value="/user")
	public String welcomeUser() {
		return "<h1> Welcome User</h1>";
	}
	
	@GetMapping(value="/admin")
	public String welcomeAdmin() {
		return "<h1> Welcome Admin</h1>";
	}
}
