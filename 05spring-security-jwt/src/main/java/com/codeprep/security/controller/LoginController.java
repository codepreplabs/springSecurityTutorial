package com.codeprep.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeprep.security.model.LoginRequest;
import com.codeprep.security.model.LoginResponse;
import com.codeprep.security.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping(value = "/login")
	public LoginResponse login(@RequestBody LoginRequest req) {
		return loginService.login(req);
	}
}
