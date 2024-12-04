package com.coolers.cloud.cloudShare.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class TokenUtil {
    private static final String SECRET = EncryptUtil.BASE_SECRET_KEY;

    // 7天的毫秒数值：1000*60*60*24*7=604800000
    private static final int EXPIRE_DAYS = 604800000;

    public static String createToken(Map<String, String> claims) {
        JWTCreator.Builder builder = JWT.create();
        claims.forEach(builder::withClaim);
        builder.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_DAYS));
        return builder.sign(Algorithm.HMAC256(SECRET));
    }

    public static DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }
}
