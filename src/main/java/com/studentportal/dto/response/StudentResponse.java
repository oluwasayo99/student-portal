package com.studentportal.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentResponse {
    private Long id;
    private UserResponse user;
    private String studentNumber;
    private LocalDate dateOfBirth;
    private String phone;
    private String address;
    private String departmentCode;
    private String degreeType;
    private Integer enrollmentYear;
    private LocalDate enrollmentDate;
    private LocalDateTime createdAt;
}
