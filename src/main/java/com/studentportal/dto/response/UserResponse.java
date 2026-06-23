package com.studentportal.dto.response;

import com.studentportal.entity.enums.Role;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private Boolean isActive;
    private LocalDateTime createdAt;
}
