package com.example.authDemo.Services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    //final variable for store the secret key
    private final SecretKey secretKey;

    //constructor to initialize and generate the secret key
    public JwtService() {
        try{
            SecretKey k = KeyGenerator.getInstance("HmacSha256").generateKey();
            this.secretKey = Keys.hmacShaKeyFor(k.getEncoded());
        }catch(Exception e){
            throw new RuntimeException("Error initializing JwtService", e);
        }
    }

    //method to generate JWT token
    public String getJwtToken() {
        return Jwts.builder()
                .subject("exampleUser")// add username for the token
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(secretKey)
                .compact();
    }

    //method to extract username from JWT token
    public String getUserNameFromToken(String token) {
        return Jwts
                .parser()
                .verifyWith(secretKey).build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
