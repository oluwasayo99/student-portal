package com.studentportal.repository;

import com.studentportal.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndIsActiveTrue(String email);
    
    Page<User> findAllByIsActiveTrue(Pageable pageable);
    
    boolean existsByEmail(String email);
}
