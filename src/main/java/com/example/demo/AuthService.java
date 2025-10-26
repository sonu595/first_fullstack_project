package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * User ko login karta hai
     * @return boolean (true agar success, false agar fail)
     */
    public boolean login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Password match check
            if (passwordEncoder.matches(password, user.getPassword())) {
                return true; // Password sahi hai
            }
        }
        return false; // User nahi mila ya password galat hai
    }

    /**
     * Naya user register karta hai
     * @return boolean (true agar register hua, false agar email pehle se exist karta hai)
     */
    public boolean register(User user) {
        // Check karo ki email pehle se database mein hai ya nahi
        if (userRepository.existsByEmail(user.getEmail())) {
            return false; // Email pehle se hai
        }
        
        // Password ko encode (hash) karke save karo
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true; // User successfully register ho gaya
    }
}