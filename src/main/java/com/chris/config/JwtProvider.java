package com.chris.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtProvider {
    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    public String generateToken(Authentication authentication) {
        long expirationTimeMillis = 24 * 60 * 60 * 1000; // 24 hours in milliseconds
        Date now = new Date();

        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationTimeMillis))
                .claim("email", authentication.getName())
                .signWith(key)
                .compact();
    }

    public String getEmailFromToken(String jwt) throws Exception{
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        }

        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
            return (String) claims.get("email");
        } catch (Exception e) {
            throw new Exception("Invalid JWT token", e);
        }
    }



}
