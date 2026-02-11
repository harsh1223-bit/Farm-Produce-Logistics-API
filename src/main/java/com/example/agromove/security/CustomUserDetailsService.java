package com.example.agromove.security;

import com.example.agromove.model.AppUser;
import com.example.agromove.repository.AppUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Loads a user from DB and converts its role(s) to GrantedAuthority.
 * Assumes AppUser has a getRole() returning a single role like "ROLE_ADMIN".
 * If your user supports multiple roles, replace the single-role logic accordingly.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepository userRepository;

    public CustomUserDetailsService(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser u = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Single-role case
        GrantedAuthority authority = new SimpleGrantedAuthority(u.getRole()); // e.g. "ROLE_ADMIN"
        return new User(u.getUsername(), u.getPassword(), Collections.singleton(authority));
    }
}
