package com.sast.sast_woc.util;

import com.sast.sast_woc.pojo.data.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class main {
    public static void main(String[] args){
        Claims claims = Jwts.parser()
                .setSigningKey("woc_key1")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6ImFkbWluMTIzIiwicm9sZSI6MSwidXNlcm5hbWUiOiLlvKDkuIkiLCJleHAiOjIwNzEyNjMxNTN9.i-f3cKNLcDpqkIdmxF5wnioDJ86KLW0mF2AQaeJltAE")
                .getBody();
        System.out.println(claims);
    }
}
