package com.example.springcloudgateway.component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

  private final long validityInMilliseconds = 3600000; // 1h

  public String createToken(String username, String role) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", role);

    String secretKey = "mySecretKeymySecretKeymySecretKeymySecretKeymySecretKey";
    return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
            .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
            .compact();
  }
}
