package com.sast.sast_woc.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class LoginJwt {
    private static final Long time = 360000000000L;
    private static final String key = "woc_key1";

    public static String creatJwt(Map<String,Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,key)
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .compact();
    }

    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
        return claims;
    }
}
