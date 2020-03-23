package com.codeprep.security.service;

import com.codeprep.security.model.LoginRequest;
import com.codeprep.security.model.LoginResponse;

public interface LoginService {

	LoginResponse login(LoginRequest req);
}
