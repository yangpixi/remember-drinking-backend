package com.yangpixi.rememberdrinkingbackend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yangpixi
 * @date 2025/12/31 16:00
 * @description jwt 签发工具类
 */

@Component
public class JwtUtil {

    private final Algorithm algorithm;
    private static final int EXPIRE_TIME = 7 * 24 * 3600 * 1000;

    public JwtUtil(@Value("${com.yangpixi.secret_key}") String secretKey) {
        algorithm = Algorithm.HMAC512(secretKey);
    }

    // 生成 token
    public String generateToken(String userId) {
        return JWT.create()
                .withSubject(userId)
                .withIssuedAt(new Date())
                .withIssuer("yangpixi")
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(algorithm);
    }

    // 解码 token
    public DecodedJWT decodedToken(String token) {
        try {
            JWTVerifier verifier = JWT
                    .require(algorithm)
                    .build();
            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException(e);
        }
    }

    // 验证 token是否过期
    public Boolean isTokenExpired(String token) {
        return decodedToken(token).getExpiresAt().before(new Date());
    }

    // 从 token中获取用户id
    public String getUserFormToken(String token) {
        return decodedToken(token).getSubject();
    }

}
