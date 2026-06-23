package com.studentportal.service;

import com.studentportal.dto.request.LoginRequest;
import com.studentportal.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);
}
