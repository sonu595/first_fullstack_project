package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Email se user dhundhne ke liye (Login ke liye)
    Optional<User> findByEmail(String email);
    
    // Check karne ke liye ki email pehle se exist karta hai (Signup ke liye)
    boolean existsByEmail(String email);
}