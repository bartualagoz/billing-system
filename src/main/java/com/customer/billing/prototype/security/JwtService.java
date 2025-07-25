package com.customer.billing.prototype.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    // 🔐 Secret key used to sign and verify tokens (keep this safe!)
    private static final String SECRET_KEY = "my-super-secret-key-that-should-be-long-enough";

    // 🔑 This method prepares the key using your secret string
    private Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes();  // convert to bytes
        return Keys.hmacShaKeyFor(keyBytes);      // create signing key
    }

    // 🏷️ Create a JWT token for a given username
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();  // you can add extra info to token here
        return createToken(claims, username);
    }

    // 🛠️ Token creation logic with expiration time
    private String createToken(Map<String, Object> claims, String subject) {
        long nowMillis = System.currentTimeMillis();
        long expirationMillis = nowMillis + 1000 * 60 * 60 * 10; // token valid for 10 hours

        return Jwts.builder()
                .setClaims(claims)                // additional data
                .setSubject(subject)              // usually the username or email
                .setIssuedAt(new Date(nowMillis)) // when the token was created
                .setExpiration(new Date(expirationMillis)) // when it will expire
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // signing
                .compact(); // build the token
    }

    // 👤 Extract username (subject) from token
    public String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();  // "subject" holds the username/email
    }

    // 📅 Extract expiration date
    private Date extractExpirationDate(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }

    // ⛔ Check if the token is expired
    private boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date()); // is now after expiration?
    }

    // ✅ Validates token by comparing username and checking expiration
    public boolean isTokenValid(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // 🔍 Reads all claims (info) inside the token
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody(); // get the actual data inside
    }
}
