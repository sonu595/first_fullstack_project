package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") 
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        
        boolean isAuthenticated = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
        
        if (isAuthenticated) {
            // Constructor fix: (message, success)
            AuthResponse response = new AuthResponse("Login successful", true);
            return ResponseEntity.ok(response);
        } else {
            // Constructor fix: (message, success)
            AuthResponse response = new AuthResponse("Invalid email or password", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@Valid @RequestBody SignupRequest signupRequest) {
        
        // SignupRequest se User object banaya
        User user = new User(
            signupRequest.getName(),
            signupRequest.getAge(),
            signupRequest.getEmail(),
            signupRequest.getPassword()
        );

        boolean isRegistered = authService.register(user);
        
        if (isRegistered) {
            // Constructor fix: (message, success)
            AuthResponse response = new AuthResponse("User registered successfully", true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            // Constructor fix: (message, success)
            AuthResponse response = new AuthResponse("Email already exists", false);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }
}