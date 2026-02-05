package com.example.agromove;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.agromove.model.AppUser;
import com.example.agromove.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AgromoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgromoveApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                AppUser admin = AppUser.builder()
                        .username("admin")
                        .password(encoder.encode("admin123"))
                        .role("ROLE_ADMIN")
                        .build();
                userRepository.save(admin);
                System.out.println("Created admin user: admin / admin123");
            }
        };
    }
}
