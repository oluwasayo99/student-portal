package com.studentportal.service.impl;

import com.studentportal.dto.request.CreateStudentRequest;
import com.studentportal.dto.response.StudentResponse;
import com.studentportal.entity.Student;
import com.studentportal.entity.User;
import com.studentportal.entity.enums.Role;
import com.studentportal.exception.DuplicateResourceException;
import com.studentportal.exception.ResourceNotFoundException;
import com.studentportal.mapper.StudentMapper;
import com.studentportal.repository.StudentRepository;
import com.studentportal.repository.UserRepository;
import com.studentportal.service.StudentService;
import com.studentportal.util.StudentNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final StudentMapper studentMapper;
    private final PasswordEncoder passwordEncoder;
    private final StudentNumberGenerator studentNumberGenerator;

    @Override
    @Transactional
    public StudentResponse enrollStudent(CreateStudentRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email is already registered");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(Role.STUDENT);
        user.setIsActive(true);

        User savedUser = userRepository.save(user);

        Student student = studentMapper.toEntity(request);
        student.setUser(savedUser);
        
        String studentNumber = studentNumberGenerator.generate(
                request.getDegreeType(), 
                request.getEnrollmentYear(), 
                request.getDepartmentCode()
        );
        student.setStudentNumber(studentNumber);
        student.setEnrollmentDate(LocalDate.now());

        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public Page<StudentResponse> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable).map(studentMapper::toResponse);
    }

    @Override
    public StudentResponse getStudentById(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return studentMapper.toResponse(student);
    }

    @Override
    public StudentResponse getStudentMe(String email) {
        User user = userRepository.findByEmailAndIsActiveTrue(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        Student student = studentRepository.findByUserId(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found"));
                
        return studentMapper.toResponse(student);
    }

    @Override
    @Transactional
    public void deleteStudent(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        User user = student.getUser();
        user.setIsActive(false);
        userRepository.save(user);
    }
}
