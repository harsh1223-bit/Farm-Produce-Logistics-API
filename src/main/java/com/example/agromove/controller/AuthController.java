package com.example.agromove.controller;

import com.example.agromove.dto.AuthRequest;
import com.example.agromove.dto.AuthResponse;
import com.example.agromove.model.AppUser;
import com.example.agromove.repository.UserRepository;
import com.example.agromove.security.JwtTokenProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserRepository userRepository, JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody Map<String,String> body){
        AppUser u = AppUser.builder()
                .username(body.get("username"))
                .password(encoder.encode(body.get("password")))
                .role(body.getOrDefault("role","ROLE_USER"))
                .build();
        return userRepository.save(u);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req){
        AppUser user = userRepository.findByUsername(req.getUsername()).orElseThrow();
        if(!encoder.matches(req.getPassword(), user.getPassword())) throw new RuntimeException("Invalid credentials");
        String token = tokenProvider.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
