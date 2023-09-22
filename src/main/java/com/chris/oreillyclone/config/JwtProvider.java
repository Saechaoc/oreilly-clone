package com.chris.oreillyclone.config;

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

    //How should I handle missing tokens? Possibly create two exceptions since this is connected to user, UserException & InvalidTokenException
    public String getEmailFromToken(String jwt) {
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        }

        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        return (String) claims.get("email");
    }



}
