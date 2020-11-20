package com.msh.www.service.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.UUID;

/**
 *对Token令牌的加密与解析
 * @author dn26
 */
public class Tokenservice {


    private static String secret = UUID.randomUUID().toString();

    /**
     * 对token进行加密
     * @return
     */
    public static String createToken() {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer("前端")
                .sign(algorithm);

        return token;
    }

    /**
     * token解析
     *
     * @param strToken
     * @return
     */
    public static DecodedJWT verifierToken(String strToken) {

        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(strToken);

        return jwt;
    }
}
