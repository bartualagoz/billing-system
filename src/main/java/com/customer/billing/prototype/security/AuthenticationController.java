package com.customer.billing.prototype.security;

import com.customer.billing.prototype.dto.AuthRequest;
import com.customer.billing.prototype.model.User;
import com.customer.billing.prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    // REGISTER endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        System.out.println("🔐 Attempting registration for: " + user.getUsername());

        if (userRepository.existsByUsername(user.getUsername())) {
            System.out.println("❌ Username already taken: " + user.getUsername());
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        System.out.println("✅ User registered: " + user.getUsername());

        return ResponseEntity.ok("User registered successfully!");
    }

    // LOGIN endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        System.out.println("🔐 Attempting login for: " + request.getUsername());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            System.out.println("✅ Authentication successful for: " + request.getUsername());

            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok("Bearer " + token);

        } catch (AuthenticationException ex) {
            System.out.println("❌ Authentication failed: " + ex.getMessage());
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
