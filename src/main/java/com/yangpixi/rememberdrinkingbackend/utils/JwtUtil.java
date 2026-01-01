package com.yangpixi.rememberdrinkingbackend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @author yangpixi
 * @date 2025/12/31 16:00
 * @description jwt 签发工具类
 */

public class JwtUtil {

    private static String SECRET_KEY;
    private final Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
    private static final int EXPIRE_TIME = 7 * 24 * 3600;

    @Value("${com.yangpixi.secret_key}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
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
    public DecodedJWT getDecodedToken(String token) {
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
        return getDecodedToken(token).getExpiresAt().before(new Date());
    }

    // 从 token中获取用户id
    public String getUserFormToken(String token) {
        return getDecodedToken(token).getSubject();
    }

}
