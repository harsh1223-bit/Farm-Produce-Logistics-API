package com.example.agromove.dto;

/**
 * Simple DTO returned after successful authentication.
 * Contains the JWT token and optional additional info.
 */
public class AuthResponse {
    private String token;
    private String username;
    private String role;

    public AuthResponse() {
    }

    // Constructor used by AuthController when returning token-only
    public AuthResponse(String token) {
        this.token = token;
    }

    // Full constructor if you want to return more data
    public AuthResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    // getters / setters
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
