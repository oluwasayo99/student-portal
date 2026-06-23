package com.studentportal.service;

import com.studentportal.dto.request.CreateUserRequest;
import com.studentportal.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    Page<UserResponse> getAllUsers(Pageable pageable);
    UserResponse getUserById(Long id);
    void deleteUser(Long id);
    UserResponse reactivateUser(Long id);
}
