package com.studentportal.security;

import com.studentportal.entity.Student;
import com.studentportal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component("studentSecurity")
@RequiredArgsConstructor
public class StudentSecurity {

    private final StudentRepository studentRepository;

    public boolean isOwner(Authentication authentication, UUID studentId) {
        String email = authentication.getName();
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            return false;
        }
        return student.getUser().getEmail().equals(email);
    }
}
