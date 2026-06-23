package com.studentportal.service;

import com.studentportal.dto.request.CreateStudentRequest;
import com.studentportal.dto.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface StudentService {
    StudentResponse enrollStudent(CreateStudentRequest request);
    Page<StudentResponse> getAllStudents(Pageable pageable);
    StudentResponse getStudentById(UUID id);
    StudentResponse getStudentMe(String email);
    void deleteStudent(UUID id);
}
