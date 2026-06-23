package com.studentportal.util;

import com.studentportal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentNumberGenerator {

    private final StudentRepository studentRepository;

    public String generate(String degreeType, int enrollmentYear, String departmentCode) {
        long count = studentRepository.countByDepartmentCodeAndEnrollmentYear(departmentCode, enrollmentYear);
        int yearShort = enrollmentYear % 100;
        long nextId = count + 1;
        
        return String.format("%s%02d%s%04d", degreeType, yearShort, departmentCode, nextId);
    }
}
