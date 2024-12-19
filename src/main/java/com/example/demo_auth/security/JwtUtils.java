package com.example.demo_auth.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret = "yourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecretyourjwtsecret";
    private final int jwtExpirationMs = 86400000;

    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
