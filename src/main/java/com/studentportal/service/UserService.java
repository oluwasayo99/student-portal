package com.studentportal.service;

import com.studentportal.dto.request.CreateUserRequest;
import com.studentportal.dto.response.UserResponse;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    Page<UserResponse> getAllUsers(Pageable pageable);
    UserResponse getUserById(UUID id);
    void deleteUser(UUID id);
    UserResponse reactivateUser(UUID id);
}
