package com.codeprep.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.codeprep.security.model.LoginRequest;
import com.codeprep.security.model.LoginResponse;
import com.codeprep.security.service.LoginService;
import com.codeprep.security.util.JwtUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Override
	public LoginResponse login(LoginRequest req) {
		
		authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
		UserDetails details = userDetailService.loadUserByUsername(req.getUsername());
		return new LoginResponse(jwtUtil.generateToken(details));
	}

}
