package com.jb.helpdesk.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;

//    public String generateToken(String email) {
//        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes()); // Converte a chave secreta para o formato correto
//        return Jwts.builder()
//                .setSubject(email)
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(key, SignatureAlgorithm.HS512) // Assinatura com HS512
//                .compact();
//    }

    public String generateToken(String email) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes()); // Gera a chave a partir da string configurada
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // Usa a expiração configurada
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
