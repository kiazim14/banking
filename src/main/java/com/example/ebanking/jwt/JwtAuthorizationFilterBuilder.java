package com.example.ebanking.jwt;

public class JwtAuthorizationFilterBuilder {
    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilterBuilder setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
        return this;
    }
}