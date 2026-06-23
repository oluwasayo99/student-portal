package com.studentportal.repository;

import com.studentportal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByUserId(UUID userId);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.departmentCode = :deptCode AND s.enrollmentYear = :year")
    long countByDepartmentCodeAndEnrollmentYear(@Param("deptCode") String deptCode, @Param("year") int year);
    
    boolean existsByStudentNumber(String studentNumber);
}
